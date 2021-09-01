package com.xiaohe66.demo.spring.source.aop.source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xiaohe
 * @since 2021.08.24 17:12
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackageClasses = AopSourceMain.class)
public class AopSourceMain {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopSourceMain.class);

        TestBean bean = context.getBean("testBean", TestBean.class);

        bean.doSth();

    }

}
