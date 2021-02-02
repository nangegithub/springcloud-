package com.github.nange.security.modules.admin.biz;

import com.github.nange.security.common.biz.BaseBiz;
import com.github.nange.security.modules.admin.entity.User;
import com.github.nange.security.modules.admin.mapper.UserMapper;
import com.github.nange.security.modules.admin.util.Sha256PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper, User> {

    private Sha256PasswordEncoder encoder = new Sha256PasswordEncoder();

    @Override
    public void insertSelective(User entity) {
        String password = encoder.encode(entity.getPassword());
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(User entity) {
        super.updateSelectiveById(entity);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }


}
