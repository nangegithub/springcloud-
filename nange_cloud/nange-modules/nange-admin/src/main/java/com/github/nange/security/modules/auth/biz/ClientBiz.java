package com.github.nange.security.modules.auth.biz;

import com.github.nange.security.common.biz.BaseBiz;
import com.github.nange.security.modules.auth.entity.Client;
import com.github.nange.security.modules.auth.entity.ClientService;
import com.github.nange.security.modules.auth.mapper.ClientMapper;
import com.github.nange.security.modules.auth.mapper.ClientServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ClientBiz extends BaseBiz<ClientMapper, Client> {
    @Autowired
    private ClientServiceMapper clientServiceMapper;
    @Autowired
    private ClientServiceBiz clientServiceBiz;

    public List<Client> getClientServices(int id) {
        return mapper.selectAuthorityServiceInfo(id);
    }

    public void modifyClientServices(int id, String clients) {
        clientServiceMapper.deleteByServiceId(id);
        if (!StringUtils.isEmpty(clients)) {
            String[] mem = clients.split(",");
            for (String m : mem) {
                ClientService clientService = new ClientService();
                clientService.setServiceId(m);
                clientService.setClientId(id+"");
                clientServiceBiz.insertSelective(clientService);
            }
        }
    }
}