package com.example.initmodule.domain.post.controller;

import com.example.initmodule.domain.post.controller.request.PostListRequest;
import com.example.initmodule.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public void getPostList(@RequestParam PostListRequest request) {

    }

}