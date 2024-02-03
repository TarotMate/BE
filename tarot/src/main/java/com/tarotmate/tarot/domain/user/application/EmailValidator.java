package com.tarotmate.tarot.domain.user.application;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailValidator {
    private final Pattern COMPILE = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

    public boolean isValidEmail(final String email) {
        return COMPILE.matcher(email).matches();
    }
}
