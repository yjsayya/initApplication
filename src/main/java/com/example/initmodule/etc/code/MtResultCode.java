package com.example.initmodule.etc.code;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:codeList/mt-result-code.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "mt.result.code")
public class MtResultCode {

    private String m0000;
    private String m2000;

    public String getM0000() {
        return m0000;
    }

    public String getM2000() {
        return m2000;
    }

    public void setM0000(String m0000) {
        this.m0000 = m0000;
    }

    public void setM2000(String m2000) {
        this.m2000 = m2000;
    }

}