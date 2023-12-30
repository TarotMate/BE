package com.tarotmate.tarot.global.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ApiResult<T> {
    private final boolean success;
    private final T response;
    private final ApiError error;

    public static <T> ApiResult<T> success(final T response) {
        return new ApiResult<>(true, response, null);
    }

    public static ApiResult<?> error(final String message) {
        return new ApiResult<>(false, null, new ApiError(message));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ApiError {
        private final String message;
    }
}
