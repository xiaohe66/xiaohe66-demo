package com.xiaohe66.demo.spring.importclass;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xiaohe
 * @since 2022.05.18 10:00
 */
@EnableImportClassAnnotation
public class ImportClassMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportClassMain.class);

        System.out.println(context.getBean("aBeanObject"));
        System.out.println(context.getBean("importBeanDefinitionObject"));
        System.out.println(context.getBean(ImportClassNotInterface.class));
    }

}
