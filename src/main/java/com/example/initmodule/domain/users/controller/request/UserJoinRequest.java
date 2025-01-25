package com.example.initmodule.domain.users.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
public class UserJoinRequest {

    @Email
    private String email;

//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$\n", message = "메세지")
    private String password; // 8 ~ 20자리 영문자 + 숫자 + 특수문자

    @Size(min = 2, max = 20)
    private String username;

}