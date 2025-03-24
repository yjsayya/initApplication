package com.example.initmodule.global.errorHandle;

import com.example.initmodule.global.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> fourasExceptionHandler(CustomException e) {
        String errorMessage = e.getMessage();
        log.info("[ForpsException] ForpsException: {}", errorMessage);
        return new ResponseEntity<>(ApiResponse.error(e.getExceptionCode().getCode(), errorMessage), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = Objects.requireNonNull(e.getBindingResult()
                .getFieldError())
                .getDefaultMessage();
        log.error("[Validation] error: {}", errorMessage);
        return ApiResponse.error(400, errorMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<Void> runtimeExceptionHandler(RuntimeException e) {
        String errorMessage = e.getMessage();
        log.error("[RuntimeException] error: {}", errorMessage, e);
        return ApiResponse.error(123, errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> exceptionHandler(Exception e) {
        log.error("UnknownException: {}", e.toString(), e);
        return ApiResponse.error(500, "Unknown Error");
    }

}