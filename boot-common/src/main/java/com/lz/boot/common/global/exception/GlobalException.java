package com.lz.boot.common.global.exception;

import lombok.Data;


@Data
public class GlobalException extends Exception {

    private int code;

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(int code, String message) {
        super(message);
        this.code = code;
    }

}