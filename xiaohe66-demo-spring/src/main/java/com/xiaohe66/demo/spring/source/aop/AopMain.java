package com.xiaohe66.demo.spring.source.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xiaohe
 * @since 2021.08.24 15:05
 */
@Configuration
//@Import(AopV1Config.class)
//@Import(AopV2Config.class)
@Import(AopV3Config.class)
public class AopMain {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopMain.class);

        People people = context.getBean("peopleProxy", People.class);
        people.say();
        System.out.println("--------------");
        people.jump();

    }

}
