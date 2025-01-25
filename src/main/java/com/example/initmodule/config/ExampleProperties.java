package com.example.initmodule.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "example", ignoreInvalidFields = true)
public class ExampleProperties {

    private final Wow wow = new Wow();

    @Data
    public static class Wow {
        private String name;
        private String age;
        private String address;
    }

}