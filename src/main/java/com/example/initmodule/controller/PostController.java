package com.example.initmodule.controller;

import com.example.initmodule.controller.request.PostListRequest;
import com.example.initmodule.controller.response.PostListResponse;
import com.example.initmodule.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public void getPostList(@RequestParam PostListRequest request) {
        System.out.println(request);
        PostListResponse response = postService.getPostList(request.toDto());

    }

}