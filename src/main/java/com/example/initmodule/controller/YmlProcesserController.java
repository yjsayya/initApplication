package com.example.initmodule.controller;

import com.example.initmodule.config.ExampleProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/yml")
public class YmlProcesserController {

    private final ExampleProperties exampleProperties;

    @GetMapping
    public void pracYmlProcesser() {
        System.out.println("wow");

        System.out.println(exampleProperties.getWow().getName());
        System.out.println(exampleProperties.getWow().getAge());
        System.out.println(exampleProperties.getWow().getAddress());
    }

}