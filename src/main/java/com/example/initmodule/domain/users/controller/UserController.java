package com.example.initmodule.domain.users.controller;

import com.example.initmodule.common.response.ApiResponse;
import com.example.initmodule.domain.users.controller.request.UserJoinRequest;
import com.example.initmodule.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ApiResponse<Void> join(@Valid @RequestBody UserJoinRequest request) {
        userService.join(request);
        return ApiResponse.success();
    }

}