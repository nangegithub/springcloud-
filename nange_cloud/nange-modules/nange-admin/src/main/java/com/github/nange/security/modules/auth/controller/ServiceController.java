package com.github.nange.security.modules.auth.controller;

import com.github.nange.security.common.msg.ObjectRestResponse;
import com.github.nange.security.common.rest.BaseController;
import com.github.nange.security.modules.auth.biz.ClientBiz;
import com.github.nange.security.modules.auth.entity.Client;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("service")
public class ServiceController extends BaseController<ClientBiz, Client> {

    @RequestMapping(value = "/{id}/client", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse modifyUsers(@PathVariable int id, String clients){
        baseBiz.modifyClientServices(id, clients);
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/{id}/client", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<Client>> getUsers(@PathVariable int id){
        return new ObjectRestResponse<List<Client>>().data(baseBiz.getClientServices(id));
    }
}
