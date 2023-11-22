package com.tarotmate.tarot.domain.fortune.ui;

import com.tarotmate.tarot.domain.fortune.application.FortuneService;
import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FortuneController {

    private final FortuneService fortuneService;

    @GetMapping("/fortune")
    public ApiResult<String> readFortune() {

        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey != null) {
            log.info("OPENAI_API_KEY exists: " + apiKey);
        } else {
            log.warn("OPENAI_API_KEY is not set in the environment variables.");
        }

        String testkey = System.getenv("testkey");
        if (testkey != null) {
            log.info("testkey exists: " + testkey);
        } else {
            log.warn("testkey is not set in the environment variables.");
        }

        String result = fortuneService.getGptResponse("hello");
        return ApiResult.success(result);
    }
}
