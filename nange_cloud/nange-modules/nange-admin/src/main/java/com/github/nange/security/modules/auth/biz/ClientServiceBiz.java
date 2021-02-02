package com.github.nange.security.modules.auth.biz;
import com.github.nange.security.common.biz.BaseBiz;
import com.github.nange.security.modules.auth.entity.ClientService;
import com.github.nange.security.modules.auth.mapper.ClientServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceBiz extends BaseBiz<ClientServiceMapper, ClientService> {
}
