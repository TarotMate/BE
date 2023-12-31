package com.tarotmate.tarot.global.errors.exception;

import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 권한 없음
@Getter
public class Exception404 extends RuntimeException {
    public Exception404(final String message) {
        super(message);
    }

    public ApiResult<?> body() {
        return ApiResult.error(getMessage());
    }

    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
    }
}