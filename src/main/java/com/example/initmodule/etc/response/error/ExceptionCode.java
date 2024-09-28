package com.example.initmodule.etc.response.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    USER_NOT_FOUND(301, "User Not Found"),
    // POST
    POST_NOT_FOUND(601, "Post Not Found"),
    POST_ALREDAY_EXISTS(602, "Post Already Exists")
    ;

    private final int code;
    private final String message;

}