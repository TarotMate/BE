package com.tarotmate.tarot.domain.user.ui;

import com.tarotmate.tarot.domain.user.application.UserService;
import com.tarotmate.tarot.domain.user.application.model.UserRegistrationInfo;
import com.tarotmate.tarot.global.utils.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

//    @ResponseStatus(HttpStatus.OK)
//    @PostMapping("/validations/email")
//    public ApiResult<Boolean> checkEmailValidation(@RequestBody final Email email) {
//        final boolean isValidEmail = emailValidator.isValidEmail(email.getEmail());
//        return ApiResult.success(isValidEmail);
//    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/user/registration")
    public ApiResult<?> signUp(@RequestBody @Valid final UserRegistrationInfo info) {
        userService.signUp(info);
        return ApiResult.success(null);
    }
}
