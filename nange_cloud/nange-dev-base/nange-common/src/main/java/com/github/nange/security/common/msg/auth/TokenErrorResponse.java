package com.github.nange.security.common.msg.auth;

import com.github.nange.security.common.constant.RestCodeConstants;
import com.github.nange.security.common.msg.BaseResponse;

public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
