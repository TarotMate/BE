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

    @Value("${OPENAI_API_KEY:기본값}")
    private String openAiApiKey;

    @GetMapping("/test")
    public String testAPI() {
        try {
            log.info("testAPI() 호출됨");
            log.info("환경 변수 OPENAI_API_KEY: {}", openAiApiKey);
            log.info("직접 읽기 : " + System.getenv("OPENAI_API_KEY"));
            return "테스트 API 작동 중, OPENAI_API_KEY: " + openAiApiKey;
        } catch (Exception e) {
            log.error("testAPI() 호출 중 오류 발생", e);
            return "테스트 API 오류 발생";
        }
    }
}
