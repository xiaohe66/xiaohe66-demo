package com.xiaohe66.demo.spring.source.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author xiaohe
 * @since 2021.08.24 10:11
 */
@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {

        System.out.println("后置处理器：SmartInstantiationAwareBeanPostProcessor # determineCandidateConstructors调用, beanName : " + beanName);

        return null;
    }
}
