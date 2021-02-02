package com.github.nange.security.modules.admin.biz;

import com.github.nange.security.common.biz.BaseBiz;
import com.github.nange.security.modules.admin.entity.Element;
import com.github.nange.security.modules.admin.mapper.ElementMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ElementBiz extends BaseBiz<ElementMapper,Element> {
    public List<Element> getAuthorityElementByUserId(String userId){
       return mapper.selectAuthorityElementByUserId(userId);
    }
    public List<Element> getAuthorityElementByUserId(String userId, String menuId){
        return mapper.selectAuthorityMenuElementByUserId(userId,menuId);
    }

    public List<Element> getAllElementPermissions(){
        return mapper.selectAllElementPermissions();
    }

    @Override
    public void insertSelective(Element entity) {
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(Element entity) {
        super.updateSelectiveById(entity);
    }
}
