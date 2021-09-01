package com.xiaohe66.demo.spring.source.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置通知
 *
 * @author xiaohe
 * @since 2021.08.24 11:29
 */
public class PeopleBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        String methodName = method.getName();
        System.out.println("aop before 调用了, methodName :" + methodName);

    }
}
