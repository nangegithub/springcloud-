package com.github.nange.security.modules.auth.util.user;

import com.github.nange.security.common.util.jwt.IJWTInfo;
import com.github.nange.security.common.util.jwt.JWTHelper;
import com.github.nange.security.configuration.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {

    @Value("${jwt.expire}")
    private int expire;
    @Autowired
    private KeyConfiguration keyConfiguration;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(),expire);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
    }


}
