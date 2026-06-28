package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// Exercise 8: Basic AOP - Before and After advice
@Aspect
public class LoggingAspect {

    // Exercise 8: Before advice
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP - Before] Method: "
                + joinPoint.getSignature().getName());
    }

    // Exercise 8: After advice
    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP - After] Method: "
                + joinPoint.getSignature().getName());
    }
}
