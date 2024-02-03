package com.tarotmate.tarot.domain.user.application.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRegistrationInfo {
    private final String email;
    private final String password;
    private final String nickname;
}
