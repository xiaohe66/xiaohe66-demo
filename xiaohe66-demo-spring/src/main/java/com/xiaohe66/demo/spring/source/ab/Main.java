package com.xiaohe66.demo.spring.source.ab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @since 2021.08.16 10:01
 */
@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        A a = (A) context.getBean("a");
        System.out.println(a);
        System.out.println(a.b);
        System.out.println(a.b.a);

    }

}
