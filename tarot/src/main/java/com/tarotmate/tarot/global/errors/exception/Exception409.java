package com.tarotmate.tarot.global.errors.exception;

import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exception409 extends RuntimeException {
    public Exception409(final String message) {
        super(message);
    }

    public ApiResult<?> body() {
        return ApiResult.error(getMessage());
    }

    public HttpStatus status() {
        return HttpStatus.CONFLICT;
    }
}
