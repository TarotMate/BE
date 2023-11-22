package com.tarotmate.tarot.domain.fortune.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FortuneService {
    @Value("${openai.accessKey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public String getGptResponse(final String prompt) {
//        String url = "https://api.openai.com/v1/engines/gpt-3.5-turbo-1106/completions";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(apiKey);
//
//        String requestBody = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 150}";
//        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
//
//        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//        return response.getBody();
        return apiKey;
    }
}