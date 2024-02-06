package com.tarotmate.tarot.domain.user.ui;

import com.tarotmate.tarot.domain.user.application.UserService;
import com.tarotmate.tarot.domain.user.application.model.UserRegistrationInfo;
import com.tarotmate.tarot.domain.user.domain.User;
import com.tarotmate.tarot.global.certification.OnRegistrationCompleteEvent;
import com.tarotmate.tarot.global.utils.ApiResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user/registration")
    public ApiResult<?> signUp(@RequestBody @Valid final UserRegistrationInfo info, final HttpServletRequest request) {
        final User registeredUser = userService.registerNewUserAccount(info);

        final String appUrl = request.getContextPath();
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registeredUser, request.getLocale(), appUrl));
        return ApiResult.success(null);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/regitrationConfirm")
    public ApiResult<?> confirmRegistration(@RequestParam("token") final String token) {
        userService.validateVerificationTokenAndActivateUser(token);
        return ApiResult.success(null);
    }
}
