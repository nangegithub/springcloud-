package com.github.nange.security.common.exception.auth;


import com.github.nange.security.common.constant.CommonConstants;
import com.github.nange.security.common.exception.BaseException;

public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
