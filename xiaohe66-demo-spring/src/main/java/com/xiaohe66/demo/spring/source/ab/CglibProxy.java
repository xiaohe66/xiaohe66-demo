package com.xiaohe66.demo.spring.source.ab;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiaohe
 * @since 2021.08.18 16:42
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("动态代理增强");

        return methodProxy.invokeSuper(o, objects);
    }
}
