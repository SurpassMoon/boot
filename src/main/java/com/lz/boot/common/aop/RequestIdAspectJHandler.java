package com.lz.boot.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Component
@Slf4j
@Aspect
public class RequestIdAspectJHandler {
    
    private static final String REQUEST_ID = "requestId";

    @Pointcut("execution(* com.lz.boot.*..*Controller.*(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //将requestId设置到MDC中
//        MDC.put(REQUEST_ID,request.getHeader(REQUEST_ID));
        MDC.put(REQUEST_ID, UUID.randomUUID().toString().replace("-",""));
        return joinPoint.proceed();
    }
}