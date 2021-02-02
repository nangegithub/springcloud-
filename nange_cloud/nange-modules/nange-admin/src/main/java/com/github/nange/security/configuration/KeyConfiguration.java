package com.github.nange.security.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class KeyConfiguration {
    @Value("${jwt.rsa-secret}")
    private String userSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;
}
