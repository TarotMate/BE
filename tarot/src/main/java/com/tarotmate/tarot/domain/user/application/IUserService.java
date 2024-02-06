package com.tarotmate.tarot.domain.user.application;

import com.tarotmate.tarot.domain.user.application.model.UserRegistrationInfo;
import com.tarotmate.tarot.domain.user.domain.User;
import com.tarotmate.tarot.global.certification.VerificationToken;

public interface IUserService {

    User registerNewUserAccount(UserRegistrationInfo userInfo);

    void createVerificationToken(User user, String token);

    void validateVerificationTokenAndActivateUser(String token) throws Exception;

    void activateUser(VerificationToken verificationToken);
}