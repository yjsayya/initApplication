package com.example.initmodule.etc.response.error;

import com.example.initmodule.etc.response.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = Objects.requireNonNull(e.getBindingResult()
            .getFieldError())
            .getDefaultMessage();
        log.error("[유효성 검사] error: {}", errorMessage);
        return ApiResult.error(100, errorMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiResult<Void> runtimeExceptionHandler(RuntimeException e) {
        String errorMessage = e.getMessage();
        log.error("[RuntimeException] error: {}", errorMessage);
        return ApiResult.error(501, errorMessage);
    }

    @ExceptionHandler(CustomException.class)
    public ApiResult<Void> customExceptionHandler(CustomException e) {
        int errorCode = e.getExceptionCode().getCode();
        String errorMessage = e.getExceptionCode().getMessage();
        log.error("[DevBlogException] {} : {}", errorCode, errorMessage);
        return ApiResult.error(errorCode, errorMessage);
    }


    @ExceptionHandler(Exception.class)
    public ApiResult<Void> exceptionHandler(Exception e) {
        log.error("UnknownException: {}", e.toString());
        return ApiResult.error(999, "Unknown Error");
    }

}