package com.tarotmate.tarot.domain.fortune.ui;

import com.tarotmate.tarot.domain.fortune.application.FortuneService;
import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FortuneController {

    private final FortuneService fortuneService;

    @GetMapping("/fortune")
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> readArticles() {
        String response = fortuneService.getGptResponse("hello World!");
        return ApiResult.success(response);
    }
}
