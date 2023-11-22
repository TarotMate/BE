package com.tarotmate.tarot.domain.fortune.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class FortuneController {

    @Value("${OPENAI_API_KEY:default}")
    private String openAiApiKey;

    @GetMapping("/test")
    public String testAPI() {
        try {
            log.info("testAPI() call");
            log.info("env OPENAI_API_KEY: {}", openAiApiKey);
            log.info("direct read : " + System.getenv("OPENAI_API_KEY"));
            return "test API ing, OPENAI_API_KEY: " + openAiApiKey;
        } catch (Exception e) {
            log.error("testAPI() call error", e);
            return "test API error";
        }
    }
}
