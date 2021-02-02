package com.github.nange.security.gate;

import com.github.nange.security.auth.client.EnableAceAuthClient;
import com.github.nange.security.gate.utils.DBLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringCloudApplication
@SpringBootApplication(scanBasePackages = {"com.github.nange.security.auth.client"})
@EnableAceAuthClient
//TODO 切换为webclient
@EnableFeignClients({"com.github.nange.security.auth.client.feign"})
public class GatewayServerBootstrap {
    public static void main(String[] args) {
        DBLog.getInstance().start();
        SpringApplication.run(GatewayServerBootstrap.class, args);
    }
}
