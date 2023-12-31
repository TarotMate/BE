package com.tarotmate.tarot.domain.fortune.ui;

import com.tarotmate.tarot.domain.fortune.application.APITestService;
import com.tarotmate.tarot.domain.fortune.application.FortuneResponseDTO;
import com.tarotmate.tarot.global.utils.ApiResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class APITestController {

    private final APITestService apiTestService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api-test")
    public ApiResult<FortuneResponseDTO> returnDefaultResponse() {
        final FortuneResponseDTO result = apiTestService.getDefaultResponse();
        return ApiResult.success(result);
    }
}
