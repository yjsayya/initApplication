package com.example.initmodule.etc.response.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private ExceptionCode exceptionCode;
    private String message;

    public CustomException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
        this.message = null;
    }

    @Override
    public String getMessage() {
        if (message == null) {
            return this.exceptionCode.getMessage();
        }
        return this.message;
    }

}