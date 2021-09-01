package com.xiaohe66.demo.spring.source.aop.source;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @since 2021.08.24 17:13
 */
@Component
@Aspect
public class PeopleAsp {


    @Pointcut("execution(* com.xiaohe66.demo.spring.source.aop.source.TestBean.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();

        System.out.println("前置通知 : " + name);
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();

        System.out.println("后置通知 : " + name);
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        String name = joinPoint.getSignature().getName();

        System.out.println("返回通知 : " + name + ",结果:" + result);
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {

        String name = joinPoint.getSignature().getName();

        System.out.println("异常通知 : " + name + ", 异常:" + e.getMessage());
    }

}
