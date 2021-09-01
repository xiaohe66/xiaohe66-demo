package com.xiaohe66.demo.spring.source.postprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @since 2021.08.16 10:01
 */
@Configuration
@ComponentScan(basePackageClasses = PostProcessorMain.class)
public class PostProcessorMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PostProcessorMain.class);

        PostProcessorTestService car = (PostProcessorTestService) context.getBean("postProcessorTestService");

    }

}
