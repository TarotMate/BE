package com.tarotmate.tarot.global.errors;


import com.tarotmate.tarot.global.errors.exception.Exception400;
import com.tarotmate.tarot.global.errors.exception.Exception401;
import com.tarotmate.tarot.global.errors.exception.Exception403;
import com.tarotmate.tarot.global.errors.exception.Exception404;
import com.tarotmate.tarot.global.errors.exception.Exception500;
import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> badRequest(final Exception400 e) {
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception401.class)
    public ResponseEntity<?> unAuthorized(final Exception401 e) {
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception403.class)
    public ResponseEntity<?> forbidden(final Exception403 e) {
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> notFound(final Exception404 e) {
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception500.class)
    public ResponseEntity<?> serverError(final Exception500 e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult<?> nullObjectError(final NullPointerException e) {
        log.error(e.getMessage(), e);
        return ApiResult.error(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult<?> unknownServerError(final RuntimeException e) {
        log.error(e.getMessage(), e);
        return ApiResult.error(e.getMessage());
    }
}
