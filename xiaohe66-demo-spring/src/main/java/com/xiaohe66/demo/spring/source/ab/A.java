package com.xiaohe66.demo.spring.source.ab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @since 2021.08.16 10:01
 */
@Component
public class A implements Say{

    @Autowired
    public B b;

    public A() {
        System.out.println("A类实例化");
    }

    @Override
    public void say() {
        System.out.println("我是A类");
    }

}
