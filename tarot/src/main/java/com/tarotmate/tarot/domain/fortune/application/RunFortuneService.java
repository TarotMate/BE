package com.tarotmate.tarot.domain.fortune.application;

import com.tarotmate.tarot.domain.fortune.application.model.TarotRequest;
import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception404;
import com.tarotmate.tarot.global.errors.exception.Exception500;
import com.tarotmate.tarot.global.utils.TarotCard;
import lombok.RequiredArgsConstructor;
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

import static com.tarotmate.tarot.global.utils.prompt.FortunePrompt.STAR_STORY;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RunFortuneService {
    @Value("${openai-api-key:defaultValue}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public String getTarotResult(final TarotRequest request) {

    // 1. Parameter값 세팅
        if (Objects.equals(apiKey, "defaultValue")) throw new Exception500(ErrorCode.ER01);

        final List<String> cardIndexes = request.getSelectedCards();
        final List<TarotCard> tarotCards = cardIndexes.stream()
                .map(TarotCard::fromNumber)
                .toList();

        // TODO: 프롬프트 케이스 추가, TodayFortune 상수화
        String prompt = null;
        if (Objects.equals(request.getFortuneType(), "TodayFortune") && Objects.equals(request.getTheme(), "StarStory"))
            prompt = STAR_STORY.createPrompt(tarotCards);

        if (Objects.equals("Prompt Not Found", prompt)) throw new Exception404(ErrorCode.ER03);

    // 2. RestTemplate 요청값 세팅
        final String defaultUrl = "https://api.openai.com/v1/chat/completions";
        final HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // JSON 요청 바디 생성
        final JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-3.5-turbo");

        final JSONArray messages = new JSONArray();

        final JSONObject systemMessage = new JSONObject();
        systemMessage.put("role", "system");
        systemMessage.put("content", STAR_STORY.getBasicSystemPrompt());
        messages.add(systemMessage);

        systemMessage.put("role", "system");
        systemMessage.put("content", STAR_STORY.getAnswerFormatSetting());
        messages.add(systemMessage);

        systemMessage.put("role", "system");
        systemMessage.put("content", STAR_STORY.getReturnTypeSetting());
        messages.add(systemMessage);

        systemMessage.put("role", "system");
        systemMessage.put("content", STAR_STORY.getAdditionalExplain());
        messages.add(systemMessage);

        final JSONObject userMessage = new JSONObject();
        userMessage.put("role", "user");
        userMessage.put("content", prompt);
        messages.add(userMessage);

        requestBody.put("messages", messages);

        // HttpEntity 생성
        final HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);

    // 3. RestTemplate을 이용한 API 요청
        final var response = restTemplate.postForEntity(defaultUrl, entity, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new Exception500(ErrorCode.ER04);
        }

    // 4. 응답값 전처리
        final String contentMessage = extractMessageFromResponse(response.getBody());
        return removeEscapeCharacters(contentMessage);
    }

    public String extractMessageFromResponse(final String openAIResponse) {
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

    public String removeEscapeCharacters(final String input) {
        if (Objects.equals(null, input)) throw new Exception500(ErrorCode.ER05);

        final String withoutNewLines = input.replace("\n", ""); // 개행으로 변환

        return withoutNewLines;//.replace("\\", ""); // 따옴표(\")를 실제 따옴표로 변환
    }
}