package com.spring.proxylab.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopLoggingAspect {

    // This aspect will log before and after the execution of methods in the service package.
    @Before("execution(* com.spring.proxylab.aop.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("AOP Aspect: Before executing doWork method called : "+ joinPoint.getSignature().getName());
    }


    // This aspect will log after the execution of methods in the service package.
    @AfterReturning(pointcut = "execution(* com.spring.proxylab.aop.service.*.*(..))", returning = "result")
    public void logAfterReturning( Object result) {
                System.out.println("AOP Aspect: After returning from doWork method returned : " + result);
    }

    // This aspect will log around the execution of methods in the service package (before and after).
    @Around("execution(* com.spring.proxylab.aop.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Around] Before: " + joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Proceed with the method execution
        long end = System.currentTimeMillis();
        System.out.println("[Around] After: " + joinPoint.getSignature().getName() + ", Time: " + (end - start) + "ms");
        return result;
    }

    // This aspect will log after throwing an exception in methods in the service package.
    @AfterThrowing(pointcut = "execution(* com.spring.proxylab.aop.service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("[AfterThrowing] Exception in method: " + joinPoint.getSignature().getName());
        ex.printStackTrace();
    }
}
