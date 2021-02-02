package com.github.nange.security.modules.admin.biz;

import com.github.nange.security.common.biz.BaseBiz;
import com.github.nange.security.modules.admin.entity.GateLog;
import com.github.nange.security.modules.admin.mapper.GateLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class GateLogBiz extends BaseBiz<GateLogMapper, GateLog> {

    @Override
    public void insert(GateLog entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(GateLog entity) {
        mapper.insertSelective(entity);
    }
}
