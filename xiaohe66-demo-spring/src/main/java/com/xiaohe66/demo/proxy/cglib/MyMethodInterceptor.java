package com.xiaohe66.demo.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiaohe
 * @since 2021.08.18 18:29
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before");

        // 这里不是反射调用。
        // 这里不能通过 method 调用，因为 method 是代理的类，会造成递归死循环。
        Object ret = methodProxy.invokeSuper(o, objects);

        System.out.println("after");

        return ret;
    }
}
