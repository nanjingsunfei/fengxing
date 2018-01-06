package cn.njupt.fengxing.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by sunfei on 2017/9/24.
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public void cn.njupt.fengxing.spring.beans.People.pet())")
    public void aspect(){}

    @Before("aspect()")
    public void startLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName +" : startLog start..");
    }

    @AfterReturning("aspect()")
    public void endLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " : endLog end..");
    }

    @Around("aspect()")
    public void aroundLog(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName +" : aroundLog start..");
        Object o = joinPoint.proceed();
        System.out.println(methodName +" : aroundLog end..");
    }
}
