package com.lz.boot.common.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/29 12:11 下午
 */
@ControllerAdvice(annotations = {RestController.class})
@Slf4j
public class RestExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotExistException.class)
    public ErrorResult handlerUserNotExistException(UserNotExistException e) {
        log.error(e.getMessage());
        return new ErrorResult(e.getCode(),e.getMessage());
    }
}
