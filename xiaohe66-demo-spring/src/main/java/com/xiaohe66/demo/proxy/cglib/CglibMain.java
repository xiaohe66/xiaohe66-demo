package com.xiaohe66.demo.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author xiaohe
 * @since 2021.08.18 18:30
 */
public class CglibMain {


    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();

        // 被动态代理的类
        enhancer.setSuperclass(TargetClass.class);

        // 设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());

        // 这里的creat方法就是正式创建代理类
        TargetClass proxy = (TargetClass) enhancer.create();

        proxy.say();

    }

}
