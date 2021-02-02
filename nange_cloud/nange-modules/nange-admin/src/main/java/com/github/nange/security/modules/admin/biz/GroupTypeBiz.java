package com.github.nange.security.modules.admin.biz;

import com.github.nange.security.common.biz.BaseBiz;
import com.github.nange.security.modules.admin.entity.GroupType;
import com.github.nange.security.modules.admin.mapper.GroupTypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupTypeBiz extends BaseBiz<GroupTypeMapper, GroupType> {
}
