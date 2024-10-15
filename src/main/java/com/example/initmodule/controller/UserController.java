package com.example.initmodule.controller;

import com.example.initmodule.controller.request.UserJoinRequest;
import com.example.initmodule.etc.response.ApiResult;
import com.example.initmodule.service.UserService;
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
    public ApiResult<Void> join(@Valid @RequestBody UserJoinRequest request) {
        userService.join(request);
        return ApiResult.success();
    }

}