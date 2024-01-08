package com.tarotmate.tarot.domain.fortune.ui;

import com.tarotmate.tarot.domain.fortune.application.APITestService;
import com.tarotmate.tarot.domain.fortune.application.ReadFortuneService;
import com.tarotmate.tarot.domain.fortune.application.InitFortuneService;
import com.tarotmate.tarot.domain.fortune.application.model.FortuneResponse;
import com.tarotmate.tarot.domain.fortune.application.model.FortuneResponseDTO;
import com.tarotmate.tarot.domain.fortune.application.model.InitialPageResponse;
import com.tarotmate.tarot.domain.fortune.application.model.TarotRequest;
import com.tarotmate.tarot.global.utils.ApiResult;
import com.tarotmate.tarot.global.utils.prompt.FortunePrompt;
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
    private final APITestService apiTestService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api-test")
    public ApiResult<FortuneResponseDTO> returnDefaultResponse() {
        final FortuneResponseDTO result = apiTestService.getDefaultResponse();
        return ApiResult.success(result);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/init")
    public InitialPageResponse returnInitialPage() {

        return initFortuneService.getTarotPage();
    }
/*
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/init2")
    public TarotPageResponse getHomePage(@RequestParam(required = false, defaultValue = "today-tarot") final String fortuneType,
                                          @RequestParam(required = false, defaultValue = "star-story") final String theme) {

        return initFortuneService.getTarotPage(fortuneType, theme);
    }
*/
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tarot")
    public ApiResult<FortuneResponse> readFortune(@RequestBody final TarotRequest tarotRequest) {

        final FortuneResponse result = readFortuneService.getTarotResult(tarotRequest);

        return ApiResult.success(result);
    }

    @GetMapping("/test")
    public String test() {
        return FortunePrompt.getReturnTypeSetting();
    }
}
