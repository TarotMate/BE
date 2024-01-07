package com.tarotmate.tarot.domain.fortune.ui;

import com.tarotmate.tarot.domain.fortune.application.RunFortuneService;
import com.tarotmate.tarot.domain.fortune.application.InitFortuneService;
import com.tarotmate.tarot.domain.fortune.application.model.TarotPageResponse;
import com.tarotmate.tarot.domain.fortune.application.model.TarotRequest;
import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FortuneController {

    private final InitFortuneService initFortuneService;
    private final RunFortuneService runFortuneService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/init")
    public TarotPageResponse getHomePage(@RequestParam(required = false, defaultValue = "today-tarot") final String fortuneType,
                                          @RequestParam(required = false, defaultValue = "star-story") final String theme) {

        return initFortuneService.getTarotPage(fortuneType, theme);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tarot")
    public ApiResult<String> readFortune(@RequestBody final TarotRequest tarotRequest) {

        final String result = runFortuneService.getTarotResult(tarotRequest);

        return ApiResult.success(result);
    }
}
