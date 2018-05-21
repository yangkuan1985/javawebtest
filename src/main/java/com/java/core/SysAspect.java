package com.java.core;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Aspect
@Component
public class SysAspect {
    final Logger logger = Logger.getLogger(SysAspect.class);

    @Pointcut("execution(* org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handle(..))")
    public void SysAspect(){
        logger.trace("SysAspect init.");
    }

    @Before("SysAspect()")
    public void doBefore(JoinPoint joinPoint) {
        logger.trace("SysAspect before.");
    }

    @AfterReturning(pointcut = "SysAspect()", returning = "result")
    public void doAfter(JoinPoint joinPoint, Object result) {
        logger.trace("SysAspect after returning.");
    }
}
