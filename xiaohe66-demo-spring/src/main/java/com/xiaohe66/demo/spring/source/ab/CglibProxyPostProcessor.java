package com.xiaohe66.demo.spring.source.ab;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author xiaohe
 * @since 2021.08.18 16:41
 */
public class CglibProxyPostProcessor {

    public static Object createProxy(Class<?> cls, String beanName) {
        // 假设A需要创建代理
        if (cls == A.class) {

            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(A.class);
            enhancer.setCallback(new CglibProxy());

            return enhancer.create();
        }

        try {
            return cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {

            e.printStackTrace();
            return null;
        }
    }
}
