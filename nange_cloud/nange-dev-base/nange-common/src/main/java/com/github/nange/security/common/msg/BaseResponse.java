package com.github.nange.security.common.msg;

public class BaseResponse {
    private int statusCode = 200;
    private String message;

    public BaseResponse(int status, String message) {
        this.statusCode = status;
        this.message = message;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
