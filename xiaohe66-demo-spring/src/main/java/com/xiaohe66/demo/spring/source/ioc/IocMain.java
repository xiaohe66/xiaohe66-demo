package com.xiaohe66.demo.spring.source.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xiaohe
 * @time 2021.08.03 16:02
 */
public class IocMain {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Car bean = context.getBean(Car.class);

        System.out.println(bean.getClass().getName());
    }

}
