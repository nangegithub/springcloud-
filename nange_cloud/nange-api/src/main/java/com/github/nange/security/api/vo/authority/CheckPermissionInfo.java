package com.github.nange.security.api.vo.authority;

import lombok.Data;

@Data
public class CheckPermissionInfo{
    // 请求权限资源
    private PermissionInfo permissionInfo;
    // 是否有权限
    private Boolean isAuth;
}
