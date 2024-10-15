package com.example.initmodule.domain.entity;

import com.example.initmodule.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAccount {

    private int userId;
    private String email;
    private String password;
    private String username;
    private UserRole userRole;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String delYn;

}