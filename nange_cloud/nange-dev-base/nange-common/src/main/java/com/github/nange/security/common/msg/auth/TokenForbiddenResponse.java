package com.github.nange.security.common.msg.auth;

import com.github.nange.security.common.constant.RestCodeConstants;
import com.github.nange.security.common.msg.BaseResponse;

public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
