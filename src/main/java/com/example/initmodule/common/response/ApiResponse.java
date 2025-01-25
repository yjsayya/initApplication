package com.example.initmodule.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private String returnMessage;
    private int code;
    private T responseData;

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>("SUCCESS", 200,null);
    }

    public static <T> ApiResponse<T> success(T result) {
        return new ApiResponse<>("SUCCESS", 200, result);
    }

    public static ApiResponse<Void> error(int code, String message) {
        return new ApiResponse<>(message, code, null);
    }

}