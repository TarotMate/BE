package com.tarotmate.tarot.domain.user.application;

import com.tarotmate.tarot.domain.user.application.model.UserRegistrationInfo;
import com.tarotmate.tarot.domain.user.domain.UserRepository;
import com.tarotmate.tarot.domain.user.domain.Users;
import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception400;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(final UserRegistrationInfo userInfo) {
        final String requestEmail = userInfo.getEmail();
        if (Objects.nonNull(userRepository.findByEmail(requestEmail))) throw new Exception400(ErrorCode.ER11.getCode());

        final String rawPassword = userInfo.getPassword();
        final String encodedPassword = passwordEncoder.encode(rawPassword);
        final String userNickname = userInfo.getNickname();

        final Users newUser = Users.builder()
                .email(requestEmail)
                .password(encodedPassword)
                .nickname(userNickname)
                .build();
        userRepository.save(newUser);
    }
}
