package com.tarotmate.tarot.global.errors;


import com.tarotmate.tarot.global.errors.exception.Exception400;
import com.tarotmate.tarot.global.errors.exception.Exception401;
import com.tarotmate.tarot.global.errors.exception.Exception403;
import com.tarotmate.tarot.global.errors.exception.Exception404;
import com.tarotmate.tarot.global.errors.exception.Exception409;
import com.tarotmate.tarot.global.errors.exception.Exception500;
import com.tarotmate.tarot.global.utils.ApiResult;
import jakarta.mail.AuthenticationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;
import java.util.stream.Collectors;


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

    @ExceptionHandler(Exception409.class)
    public ResponseEntity<?> conflict(final Exception409 e) {
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception500.class)
    public ResponseEntity<?> serverError(final Exception500 e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResult<?>> validationError(final MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(ApiResult.error(e.getAllErrors().get(0).getDefaultMessage()));
    }
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ApiResult<?>> mailError(final AuthenticationFailedException e) {
        return ResponseEntity.internalServerError().body(ApiResult.error(e.getMessage()));
    }

    @ExceptionHandler(MailSendException.class)
    public ResponseEntity<ApiResult<?>> mailConfirmError(final MailSendException e) {
        return ResponseEntity.internalServerError().body(ApiResult.error(e.getMessage()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResult<?>> nullObjectError(final NullPointerException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.internalServerError().body(ApiResult.error(e.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult<?> unknownServerError(final RuntimeException e) {
        log.error(e.getMessage(), e);
        return ApiResult.error(e.getMessage());
    }
}
