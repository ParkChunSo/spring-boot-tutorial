package com.hack.springboottutorial.aspect;

import com.hack.springboottutorial.exception.UserDefineException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectException {
    private Logger logger = LoggerFactory.getLogger(AspectException.class);

    @Pointcut("execution(* com.hack.springboottutorial.service.LoginService.login(..))")
    public void login() {
    }

    @Around("login()")
    private Object aroundLoginException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = new Object();
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            String exceptionMethod = e.getStackTrace()[0].getMethodName();
            throw new UserDefineException("로그인 과정에서 오류", e.toString(), exceptionMethod);
        }

        return result;
    }

}
