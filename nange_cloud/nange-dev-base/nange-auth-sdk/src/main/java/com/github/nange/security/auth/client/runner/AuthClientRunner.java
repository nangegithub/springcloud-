package com.github.nange.security.auth.client.runner;

import com.github.nange.security.auth.client.config.ServiceAuthConfig;
import com.github.nange.security.auth.client.config.UserAuthConfig;
import com.github.nange.security.auth.client.feign.ServiceAuthFeign;
import com.github.nange.security.common.msg.BaseResponse;
import com.github.nange.security.common.msg.ObjectRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 监听完成时触发
 */
@Configuration
@Slf4j
public class AuthClientRunner implements CommandLineRunner {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化加载用户pubKey");
    }

//    @Override
//    public void run(String... args) throws Exception {
//        log.info("初始化加载用户pubKey");
//        try {
//            refreshUserPubKey();
//        }catch(Exception e){
//            log.error("初始化加载用户pubKey失败,1分钟后自动重试!",e);
//        }
//    }
//
//    @Scheduled(cron = "0 0/1 * * * ?")
//    public void refreshUserPubKey(){
//        BaseResponse resp = serviceAuthFeign.getUserPublicKey(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
//        if (resp.getStatusCode() == HttpStatus.OK.value()) {
//            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
//            this.userAuthConfig.setPubKeyByte(userResponse.getData());
//        }
//    }


}