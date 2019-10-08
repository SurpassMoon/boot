package com.lz.boot.common.global.exception;

public class UserNotExistException extends GlobalException {

    public UserNotExistException(String message, int code) {
        super(code, message);
    }
}