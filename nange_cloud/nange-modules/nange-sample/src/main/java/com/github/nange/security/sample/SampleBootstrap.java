package com.github.nange.security.sample;

import com.github.nange.security.auth.client.EnableAceAuthClient;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication(scanBasePackages = {"com.github.nange.security.auth.client"})
@EnableTransactionManagement
@MapperScan(basePackages = {"com.github.nange.security.sample.mapper"})
@EnableSwagger2Doc
@EnableAceAuthClient
@EnableFeignClients({"com.github.nange.security.auth.client.feign"})
public class SampleBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SampleBootstrap.class).run(args);
    }
}
