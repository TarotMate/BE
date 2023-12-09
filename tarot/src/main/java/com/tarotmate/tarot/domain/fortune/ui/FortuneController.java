package com.tarotmate.tarot.domain.fortune.ui;

import com.tarotmate.tarot.domain.fortune.application.FortuneService;
import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FortuneController {

    private final FortuneService fortuneService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fortune")
    public ApiResult<String> readFortune() {

        final String result = fortuneService.getTodayFortune("The Chariot");
        return ApiResult.success(result);
    }
}
