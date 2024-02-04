package com.tarotmate.tarot.domain.user.application.model;

import com.tarotmate.tarot.global.validation.PasswordMatches;
import com.tarotmate.tarot.global.validation.ValidEmail;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@PasswordMatches
public class UserRegistrationInfo {
    @NotNull @NotEmpty @ValidEmail
    private final String email;
    @NotNull @NotEmpty
    private final String password;
    private final String matchingPassword;
    @NotNull @NotEmpty
    private final String nickname;
}
