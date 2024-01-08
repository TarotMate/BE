package com.tarotmate.tarot.domain.fortune.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarotmate.tarot.domain.fortune.application.model.FortuneResponse;
import com.tarotmate.tarot.domain.fortune.application.model.TarotRequest;
import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception500;
import com.tarotmate.tarot.global.utils.TarotCard;
import com.tarotmate.tarot.global.utils.prompt.FortunePrompt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;


@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReadFortuneService {
    @Value("${openai-api-key:defaultValue}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public FortuneResponse getTarotResult(final TarotRequest request) {

    // 1. 파라미터값 세팅
        if (Objects.equals(apiKey, "defaultValue")) throw new Exception500(ErrorCode.ER01);

        final List<Integer> cardIndexes = request.getSelectedCardNumbers();
        final List<TarotCard> tarotCards = cardIndexes.stream()
                .map(TarotCard::fromNumber)
                .toList();

    // 2. RestTemplate 요청값 세팅
        final String defaultUrl = "https://api.openai.com/v1/chat/completions";
        final HttpEntity<String> entity = getRequestEntity(request, tarotCards); // HttpEntity 생성


    // 3. RestTemplate을 이용한 API 요청
        final var response = restTemplate.postForEntity(defaultUrl, entity, String.class);
        if (!response.getStatusCode().is2xxSuccessful()) throw new Exception500(ErrorCode.ER04);
        log.info(response.getBody());

    // 4. 응답값 전처리
        final String contentMessage = extractMessageFromResponse(response.getBody());
        log.info(contentMessage);

    // 5. 응답값 DTO 파싱
        final ObjectMapper mapper = new ObjectMapper();

        final FortuneResponse fortuneResponse;
        try {
            fortuneResponse = mapper.readValue(contentMessage, FortuneResponse.class);
        } catch (JsonProcessingException e) {
            throw new Exception500(ErrorCode.ER08);
        }


        return fortuneResponse;
    }

    private HttpEntity<String> getRequestEntity(final TarotRequest request, final List<TarotCard> tarotCards) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // JSON 요청 바디 생성
        final JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-3.5-turbo-1106");

        final JSONObject type = new JSONObject();
        type.put("type", "json_object");
        requestBody.put("response_format", type);

        final JSONArray messages = new JSONArray();
        final JSONObject systemMessage = new JSONObject(); //시스템 프롬프트
        final JSONObject userMessage = new JSONObject(); //유저 프롬프트

        // 3. 프롬프트 생성 & RequestBody에 삽입
        systemMessage.put("role", "system");
        systemMessage.put("content", FortunePrompt.getBasicSystemPrompt()); //기본적인 타로 시스템 프롬프트
        messages.add(systemMessage);

        systemMessage.put("role", "system");
        systemMessage.put("content", FortunePrompt.getFortuneTypeInfo(request.getFortuneType(), request.getTheme())); //fortuneType, theme에 따라 달라지는 시스템 프롬프트
        messages.add(systemMessage);

        systemMessage.put("role", "system");
        systemMessage.put("content", FortunePrompt.getReturnTypeSetting()); // return Type Json으로 지정하는 시스템 프롬프트
        messages.add(systemMessage);

        systemMessage.put("role", "system");
        systemMessage.put("content", FortunePrompt.getAdditionalExplain()); // return하는 필드값에 대한 부가 설명
        messages.add(systemMessage);

        final String userPrompt = FortunePrompt.createUserPrompt(tarotCards, request.getCardDescriptions());

        userMessage.put("role", "user");
        userMessage.put("content", userPrompt); //유저가 뽑은 카드들에 대한 정보를 제공하는 유저 프롬프트
        messages.add(userMessage);

        requestBody.put("messages", messages);

        return new HttpEntity<>(requestBody.toString(), headers); // HttpEntity 생성
    }

    private String extractMessageFromResponse(final String openAIResponse) {
        final JSONObject jsonObject = convertStringToJsonObject(openAIResponse);

        final JSONArray jsonArray = (JSONArray) Objects.requireNonNull(jsonObject.get("choices"));

        final JSONObject firstChoice = (JSONObject) Objects.requireNonNull(jsonArray.get(0));

        final JSONObject message = (JSONObject) Objects.requireNonNull(firstChoice.get("message"));

        return message.get("content").toString();
    }

    private JSONObject convertStringToJsonObject(final String jsonString) {
        final JSONParser parser = new JSONParser();

        JSONObject jsonResponse = null;
        try{
            jsonResponse = (JSONObject) parser.parse(jsonString);
        } catch (final ParseException e) {
            throw new Exception500(ErrorCode.ER05);
        }
        if (Objects.equals(null, jsonResponse)) throw new Exception500(ErrorCode.ER05);

        return jsonResponse;
    }
}