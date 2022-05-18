package com.xiaohe66.demo.spring.importclass;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xiaohe
 * @since 2022.05.18 10:10
 */
public class ImportClassBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        System.out.println("导入bean定义方法被执行");

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Object.class);

        // 注册 bean 定义
        registry.registerBeanDefinition("importBeanDefinitionObject", builder.getBeanDefinition());
    }
}
