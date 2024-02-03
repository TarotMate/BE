package com.tarotmate.tarot;

import com.tarotmate.tarot.domain.user.application.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EmailValidatorTest {
    private EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    public void valid_email_return_true() {
        final String validEmail = "example@naver.com";
        assertTrue(emailValidator.isValidEmail(validEmail), "유효하지 않는 이메일 주소입니다.");
    }

    @Test
    public void email_without_at_Sign_return_false() {
        final String invalidEmail = "examplenaver.com";
        assertFalse(emailValidator.isValidEmail(invalidEmail), "유효한 이메일 주소입니다.");
    }

    @Test
    public void email_without_dot_return_false() {
        final String invalidEmail = "example@navercom";
        assertFalse(emailValidator.isValidEmail(invalidEmail), "유효한 이메일 주소입니다.");
    }

    @Test
    public void one_character_domain_return_false() {
        final String invalidEmail = "example@naver.m";
        assertFalse(emailValidator.isValidEmail(invalidEmail), "유효한 이메일 주소입니다.");
    }
}
