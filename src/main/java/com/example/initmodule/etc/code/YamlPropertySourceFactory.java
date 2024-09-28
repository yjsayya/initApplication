package com.example.initmodule.etc.code;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.util.Objects;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) {
        // YamlPropertiesFactoryBean을 사용하여 YAML 파일을 읽어 Properties로 변환
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());  // EncodedResource에서 Resource 객체를 가져옴
        Properties properties = factory.getObject();

        // PropertiesPropertySource로 반환
        return new PropertiesPropertySource((resource.getResource().getFilename() != null) ?
                resource.getResource().getFilename() : name,
                Objects.requireNonNull(properties, "yml 파일 없음")
        );
    }

}