package com.github.nange.security.modules.admin.rpc;

import com.github.nange.security.api.vo.log.LogInfo;
import com.github.nange.security.modules.admin.biz.GateLogBiz;
import com.github.nange.security.modules.admin.entity.GateLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/api")
@RestController
@Slf4j
public class LogRest {
    @Autowired
    private GateLogBiz gateLogBiz;

    @RequestMapping(value = "/log/save", method = RequestMethod.POST)
    public @ResponseBody
    void saveLog(@RequestBody LogInfo info) {
        GateLog log = new GateLog();
        BeanUtils.copyProperties(info, log);
        log.setCrtTime(new Date(info.getCrtTime()));
        gateLogBiz.insertSelective(log);
    }
}
