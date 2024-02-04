package com.tarotmate.tarot.global.validation;

import com.tarotmate.tarot.domain.user.application.model.UserRegistrationInfo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context){
        final UserRegistrationInfo user = (UserRegistrationInfo) obj;
        return Objects.equals(user.getPassword(),user.getMatchingPassword());
    }
}