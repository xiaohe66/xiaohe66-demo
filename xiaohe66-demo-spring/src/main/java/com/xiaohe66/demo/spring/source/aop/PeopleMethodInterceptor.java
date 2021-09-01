package com.xiaohe66.demo.spring.source.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知
 *
 * @author xiaohe
 * @since 2021.08.24 15:24
 */
public class PeopleMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        String name = getClass().getName();
        System.out.println("PeopleMethodInterceptor - 调用前: " + name);

        Object ret = methodInvocation.proceed();

        System.out.println("PeopleMethodInterceptor - 调用后: " + name);

        return ret;
    }
}
