package com.tarotmate.tarot.domain.fortune.ui;

import com.tarotmate.tarot.domain.fortune.application.FortuneService;
import com.tarotmate.tarot.domain.fortune.application.model.TarotRequest;
import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FortuneController {

    private final FortuneService fortuneService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public ApiResult<String> getTarotPage() {return ApiResult.success("");}

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tarot")
    public ApiResult<String> readFortune(@RequestBody final TarotRequest tarotRequest) {

        final String result = fortuneService.getTodayFortune(tarotRequest);

        return ApiResult.success(result);
    }

    @PostMapping("/test")
    public ApiResult<String> extractJson(@RequestBody final String jsonRes) {

        String result = fortuneService.extractMessageFromResponse(jsonRes);
        result = fortuneService.removeEscapeCharacters(result);

        return ApiResult.success(result);
    }
}
