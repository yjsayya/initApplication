package com.example.initmodule.global.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mt.result.code")
@PropertySource(value="classpath:codeList/mt-result-code.yml", factory = YamlPropertySourceFactory.class)
public class MtResultCode {

    private String m0000;
    private String m2000;

}