package com.github.nange.security.auth.client.exception;

public class JwtTokenExpiredException extends Exception {
    public JwtTokenExpiredException(String s) {
        super(s);
    }
}
