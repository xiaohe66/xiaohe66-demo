package com.xiaohe66.demo.proxy.jdk;

/**
 * jdk动态代理
 *
 * @author xiaohe
 * @since 2021.08.18 18:36
 */
public class JdkProxyMain {

    public static void main(String[] args) {

        TargetClass targetClass = new TargetClass();

        // jdk 动态代理只能使用父类、或者接口来接收
        //TargetClass proxy = new JdkProxy(targetClass).getProxy();

        TargetClassSuper proxy = new JdkProxy(targetClass).getProxy();

        proxy.say();

    }

}
