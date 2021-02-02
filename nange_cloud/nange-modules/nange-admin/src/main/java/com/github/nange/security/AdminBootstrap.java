package com.github.nange.security;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.github.nange.security.modules.*.mapper")
@EnableSwagger2Doc
@EnableAsync
public class AdminBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminBootstrap.class).run(args);    }
}
