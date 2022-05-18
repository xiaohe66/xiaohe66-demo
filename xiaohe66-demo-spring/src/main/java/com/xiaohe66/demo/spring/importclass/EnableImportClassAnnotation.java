package com.xiaohe66.demo.spring.importclass;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用 {@link Import} 可以导入
 * {@link org.springframework.context.annotation.ImportSelector} 和
 * {@link org.springframework.context.annotation.ImportBeanDefinitionRegistrar} 的实现类，并自动调用方法,
 * 若没有实现这2个接口，也会实例化，但不会自动调用方法。
 *
 * @author xiaohe
 * @since 2022.05.18 09:58
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ImportClassNameSelector.class, ImportClassBeanDefinitionRegistrar.class, ImportClassNotInterface.class})
public @interface EnableImportClassAnnotation {

}
