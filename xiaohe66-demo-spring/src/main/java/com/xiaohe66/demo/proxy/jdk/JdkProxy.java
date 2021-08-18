package com.xiaohe66.demo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiaohe
 * @since 2021.08.18 18:39
 */
public class JdkProxy implements InvocationHandler {

    private final Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");

        Object ret = method.invoke(target, args);

        System.out.println("after");

        return ret;
    }
}
