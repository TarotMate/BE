package com.tarotmate.tarot.domain.fortune.ui;

import com.tarotmate.tarot.domain.fortune.application.APITestService;
import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class APITestController {

    private final APITestService apiTestService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api-test")
    public ApiResult<String> returnDefaultResponse() {
        final String result = apiTestService.getDefaultResponse();
        return ApiResult.success(result);
    }
}
