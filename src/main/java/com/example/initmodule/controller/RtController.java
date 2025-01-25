package com.example.initmodule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class RtController {

    private final RestTemplate restTemplate;

    @PostMapping("/api/prac/rest/template")
    public void rest(@RequestBody HashMap<String, String> params) {
        String param1 = params.get("param1");
        String param2 = params.get("param2");
        String param3 = params.get("param3");


    }



}