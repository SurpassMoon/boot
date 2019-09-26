package com.lz.boot.common.global.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.lz.boot.web.*.*(..))")
    public void logPointcut() {
    }

    @Before("logPointcut()")
    public void logBeforeController(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        log.info("请求url:{}", request.getRequestURL().toString());
        log.info("请求方法名:{}", joinPoint.getSignature().getName());
        log.info("请求参数:{}", Arrays.toString(joinPoint.getArgs()));


    }

    @AfterReturning(returning = "responseEntity", pointcut = "logPointcut()")
    public void logBeforeController(ResponseEntity responseEntity) {
        log.info("请求结果:{}", responseEntity);
    }

}