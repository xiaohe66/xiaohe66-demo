package com.xiaohe66.demo.spring.source.ab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @since 2021.08.16 10:01
 */
@Component
public class B{

    @Autowired
    public A a;


    public B() {
        System.out.println("B类实例化");
    }

    public void say() {
        System.out.println("我是B类");
    }
}
