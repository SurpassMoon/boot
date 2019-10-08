package com.lz.boot.common.global.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/10/4 7:58 下午
 */
@Data
@AllArgsConstructor
public class ErrorResult {
    private int code;
    private String error;
}
