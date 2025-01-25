package com.example.initmodule.common.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "imc", ignoreInvalidFields = true)
public class ImcProperties {

    private Mt mt = new Mt();
    private String ft;
    private String at;

    @Getter
    @Setter
    public static class Mt {
        private String sms;
        private String lms;
        private String mms;
    }

}