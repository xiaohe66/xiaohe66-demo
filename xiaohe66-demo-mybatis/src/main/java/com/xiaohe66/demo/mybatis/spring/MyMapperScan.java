package com.xiaohe66.demo.mybatis.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiaohe
 * @since 2022.03.04 10:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MapperScanImportBeanDefinitionRegistrar.class)
public @interface MyMapperScan {

    String value();
}
