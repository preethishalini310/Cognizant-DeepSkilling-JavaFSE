package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

// Exercise 3: Aspect class for logging method execution times
@Aspect
public class LoggingAspect {

    // Exercise 3: Around advice to log execution time
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("[AOP] Method: " + joinPoint.getSignature().getName()
                + " | Execution time: " + (endTime - startTime) + " ms");

        return result;
    }
}
