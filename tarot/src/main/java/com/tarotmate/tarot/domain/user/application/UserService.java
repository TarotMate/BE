package com.tarotmate.tarot.domain.user.application;

import com.tarotmate.tarot.domain.user.application.model.UserRegistrationInfo;
import com.tarotmate.tarot.domain.user.domain.UserRepository;
import com.tarotmate.tarot.domain.user.domain.User;
import com.tarotmate.tarot.global.certification.VerificationToken;
import com.tarotmate.tarot.global.certification.VerificationTokenRepository;
import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception401;
import com.tarotmate.tarot.global.errors.exception.Exception404;
import com.tarotmate.tarot.global.errors.exception.Exception409;
import com.tarotmate.tarot.global.errors.exception.Exception500;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;

    @Override
    public User registerNewUserAccount(final UserRegistrationInfo userInfo) {
        final String requestEmail = userInfo.getEmail();
        if (Objects.nonNull(userRepository.findByEmail(requestEmail))) throw new Exception409(ErrorCode.ER11.getCode());

        final String rawPassword = userInfo.getPassword();
        final String encodedPassword = passwordEncoder.encode(rawPassword);
        final String userNickname = userInfo.getNickname();

        final User newUser = User.builder()
                .email(requestEmail)
                .password(encodedPassword)
                .nickname(userNickname)
                .build();
        userRepository.save(newUser);
        return newUser;
    }
    @Override
    public void createVerificationToken(final User user, final String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

    @Override
    public void validateVerificationTokenAndActivateUser(final String token) {
        final VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (Objects.isNull(verificationToken)) throw new Exception404(ErrorCode.ER13.getCode());
        if (verificationToken.isExpired()) {
            tokenRepository.delete(verificationToken);
            throw new Exception401(ErrorCode.ER15.getCode());
        }
        activateUser(verificationToken);
    }

    @Override
    public void activateUser(final VerificationToken verificationToken) {
        final User user = verificationToken.getUser();
        if (Objects.isNull(user)) throw new Exception500(ErrorCode.ER14.getCode());
        user.authenticationSuccess();
        userRepository.save(user);
    }
}
