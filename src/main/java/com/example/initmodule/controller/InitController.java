package com.example.initmodule.controller;

import com.example.initmodule.etc.code.MtResultCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InitController {

    private final MtResultCode mtResultCode;

    @GetMapping("/")
    public String index() {
        log.info("wowowowwo");
        log.info("yml 파일 잘 읽어올 수 있나? : {}", mtResultCode.getM0000());
        log.info("yml 파일 잘 읽어올 수 있나? : {}", mtResultCode.getM2000());
        return "hi";
    }


}