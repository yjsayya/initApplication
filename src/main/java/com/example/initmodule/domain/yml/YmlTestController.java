package com.example.initmodule.domain.yml;

import com.example.initmodule.common.properties.ImcProperties;
import com.example.initmodule.common.response.ApiResponse;
import com.example.initmodule.common.properties.MtResultCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/yml/properties")
public class YmlTestController {

    private final ImcProperties imcProperties;
    private final MtResultCode mtResultCode;

    @GetMapping("/internal")
    public ResponseEntity<ApiResponse<Void>> readProperties() {
        log.info("yml 파일 잘 읽어오자 - at: {}", imcProperties.getAt());
        log.info("yml 파일 잘 읽어오자 - ft: {}", imcProperties.getFt());
        log.info("yml 파일 잘 읽어오자 - mt/sms: {}", imcProperties.getMt().getSms());
        log.info("yml 파일 잘 읽어오자 - mt/lms: {}", imcProperties.getMt().getLms());
        log.info("yml 파일 잘 읽어오자 - mt/mms: {}", imcProperties.getMt().getMms());
        return ResponseEntity.status(200).body(ApiResponse.success());
    }

    @GetMapping("/external")
    public ResponseEntity<ApiResponse<Void>> ymlConfig() {
        log.info("yml 파일 잘 읽어올 수 있나? - M0000: {}", mtResultCode.getM0000());
        log.info("yml 파일 잘 읽어올 수 있나? - M2000: {}", mtResultCode.getM2000());
        return ResponseEntity.status(200).body(ApiResponse.success());
    }

}