package com.tarotmate.tarot.domain.fortune.application;

import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception500;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FortuneService {
    @Value("${openai-api-key:defaultValue}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public String getTodayFortune(final String card) {
        if (Objects.equals(apiKey, "defaultValue")) throw new Exception500(ErrorCode.ER01);

        try {
            final String defaultUrl = "https://api.openai.com/v1/chat/completions";

            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            final Map<String, Object> body = new HashMap<>();
            body.put("model", "gpt-3.5-turbo");
            body.put("messages", List.of(
                    Map.of("role", "system", "content", "You are a tarot reader. Your guests would like to know about their luck for the day. The guest draws only one card, and when it is presented to you, you must provide an interpretation of it. Your customer is Korean, so please answer in Korean."),
                    Map.of("role", "user", "content", card)
            ));
            final HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

            final OpenAIResponseDTO response = restTemplate.postForObject(defaultUrl, request, OpenAIResponseDTO.class);

            final OpenAIResponseDTO.Message message = Objects.requireNonNull(response).getChoices().get(0).getMessage();
            final String content = Objects.requireNonNull(message).getContent();
//.replace("\n", " ").replace("\\\"", "'")
            return content;
        } catch (final RestClientException e) {
            throw new RuntimeException(e);
        }
    }
}