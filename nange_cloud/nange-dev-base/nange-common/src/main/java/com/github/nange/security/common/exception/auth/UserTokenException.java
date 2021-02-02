package com.github.nange.security.common.exception.auth;


import com.github.nange.security.common.constant.CommonConstants;
import com.github.nange.security.common.exception.BaseException;

public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
