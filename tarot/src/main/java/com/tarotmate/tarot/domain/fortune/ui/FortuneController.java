package com.tarotmate.tarot.domain.fortune.ui;

import com.tarotmate.tarot.domain.fortune.application.ReadFortuneService;
import com.tarotmate.tarot.domain.fortune.application.InitFortuneService;
import com.tarotmate.tarot.domain.fortune.application.model.FortuneResponse;
import com.tarotmate.tarot.domain.fortune.application.model.InitialPageResponse;
import com.tarotmate.tarot.domain.fortune.application.model.TarotRequest;
import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FortuneController {

    private final InitFortuneService initFortuneService;
    private final ReadFortuneService readFortuneService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/init")
    public ApiResult<InitialPageResponse> returnInitialPage() {

        return ApiResult.success(initFortuneService.getTarotPage());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tarot")
    public ApiResult<FortuneResponse> readFortune(@RequestBody final TarotRequest tarotRequest) {

        final FortuneResponse result = readFortuneService.getTarotResult(tarotRequest);

        return ApiResult.success(result);
    }
}
