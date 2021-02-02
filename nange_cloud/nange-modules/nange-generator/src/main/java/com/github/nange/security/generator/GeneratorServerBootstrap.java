package com.github.nange.security.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan({"com.github.nange.security.common","com.github.nange.security.generator"})
@MapperScan("com.github.nange.security.generator.mapper")
public class GeneratorServerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorServerBootstrap.class, args);
    }
}
