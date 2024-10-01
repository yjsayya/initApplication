package com.example.initmodule.etc.response.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),
    // POST
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Post Not Found"),
    POST_ALREDAY_EXISTS(HttpStatus.CONFLICT, "Post Already Exists"),

    INTERVAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error")
    ;

    private final HttpStatus httpStatus;
    private final String message;

}