package com.xiaohe66.demo.spring.source.reader;

import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 可以直接把某个类转换为BeanDefinition，并且会解析该类上的注解
 *
 *
 *
 * @author xiaohe
 * @since 2022.02.28 11:41
 */
public class AnnotatedBeanDefinitionReaderDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);

        //可以解析的注解有 @Conditional，@Scope、@Lazy、@Primary、@DependsOn、@Role、@Description
        reader.register();

    }

}
