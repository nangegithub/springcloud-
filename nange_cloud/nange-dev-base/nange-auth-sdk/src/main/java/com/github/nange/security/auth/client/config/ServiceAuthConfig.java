package com.github.nange.security.auth.client.config;

import feign.Feign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@AutoConfigureBefore(FeignAutoConfiguration.class)
@Configuration
@ConditionalOnClass(Feign.class)
public class ServiceAuthConfig {
    private byte[] pubKeyByte;
    @Value("${auth.client.id:null}")
    private String clientId;
    @Value("${auth.client.secret}")
    private String clientSecret;
    @Value("${spring.application.name}")
    private String applicationName;

    public String getClientId() {
        return "null".equals(clientId)?applicationName:clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public byte[] getPubKeyByte() {
        return pubKeyByte;
    }

    public void setPubKeyByte(byte[] pubKeyByte) {
        this.pubKeyByte = pubKeyByte;
    }
}
