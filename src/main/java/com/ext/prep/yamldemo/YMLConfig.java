package com.ext.prep.yamldemo;

import com.ext.prep.yamldemo.factory.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Configuration
@PropertySource(value = "classpath:config.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "server")
public class YMLConfig {

    private Map<String, String> application;
    private Map<String, List<String>> config;
    private Map<String, UserDetail> users;

    public void show(){
        System.out.println(application);
        System.out.println(config);
        System.out.println(users);
    }
}
