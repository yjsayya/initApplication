package com.example.initmodule.global.errorHandle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    // COMMON ERROR
    SQL_ERROR(500, "SQL Error")
    ,DATABASE_ACCESS_ERROR(500, "Database Access Error")
    ,NO_SUCH_FILE(400, "Empty File")
    ,FILE_ERROR_DURING_SAVE(500, "File Error During Saving")
    // USER
    ,USER_NOT_FOUND(404, "User Not Found")
    ,USER_ALREADY_EXISTS(409, "User Already Exists")
    ,INVALID_PASSWORD(401, "Invalid Password")
    ,UNAUTHORIZED_USER(401, "Unauthorized User")
    ,NO_AUTHORITIES(400, "No Authorities")
    // COMPANY
    ,COMPANY_NOT_FOUND(404, "Company Not Found")
    ,COMPANY_ALREADY_EXISTS(400, "Company Already Exists")
    // ORDER
    ,NO_SUCH_ORDER(404, "No Such OrderInfo")
    ,EMPTY_ORDER_INFO(400, "Empay Order Info")
    ;

    private final int code;
    private final String message;

}