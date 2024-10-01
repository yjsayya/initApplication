package com.example.initmodule.etc.response.error;

import com.example.initmodule.etc.response.ApiResult;
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
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = Objects.requireNonNull(e.getBindingResult()
            .getFieldError())
            .getDefaultMessage();
        log.error("[Invalid Input] {}", errorMessage);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResult.error(Integer.parseInt(HttpStatus.BAD_REQUEST.name()), errorMessage));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandler(RuntimeException e) {
        String errorMessage = e.getMessage();
        log.error("[RuntimeException] {}", errorMessage);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResult.error(Integer.parseInt(HttpStatus.INTERNAL_SERVER_ERROR.name()), errorMessage));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> customExceptionHandler(CustomException e) {
        HttpStatus status = e.getExceptionCode().getHttpStatus();
        String errorMessage = e.getExceptionCode().getMessage();
        log.error("[CustomException] {}", errorMessage);

        return ResponseEntity
                .status(status)
                .body(ApiResult.error(Integer.parseInt(status.name()), errorMessage));
    }

    @ExceptionHandler(Exception.class)
    public ApiResult<Void> exceptionHandler(Exception e) {
        log.error("UnknownException: {}", e.toString());
        return ApiResult.error(999, "Unknown Error");
    }

}