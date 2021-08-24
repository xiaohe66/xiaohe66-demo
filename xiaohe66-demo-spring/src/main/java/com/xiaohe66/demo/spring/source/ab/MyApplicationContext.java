package com.xiaohe66.demo.spring.source.ab;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaohe
 * @since 2021.08.18 15:56
 */
public class MyApplicationContext {

    private static Map<String, RootBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 一级缓存，单例池，保存完整对象（完成属性赋值）
     */
    private static final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 二级缓存，早期对象，保存不完整对象（未完成属性赋值），若被动态代理，则保存的是动态代理后的对象。
     */
    private static Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>();

    /**
     * 二级缓存，早期对象，保存不完整对象（未完成属性赋值），若被动态代理，则保存的是动态代理后的对象。
     */
    private static Map<String, ObjectFactory<Object>> singletonFactories = new ConcurrentHashMap<>();

    private static Set<String> singletonCurrentlyInCreationObjects = new HashSet<>();


    private static void registerBeanDefinition() {
        // 注册 bean定义
        beanDefinitionMap.put("a", new RootBeanDefinition(A.class));
        beanDefinitionMap.put("b", new RootBeanDefinition(B.class));
    }

    private static Object createBean(String name) throws IllegalAccessException, InstantiationException {

        if (!singletonCurrentlyInCreationObjects.contains(name)) {
            singletonCurrentlyInCreationObjects.add(name);
        }

        RootBeanDefinition definition = beanDefinitionMap.get(name);
        Class<?> beanClass = definition.getBeanClass();

        // 动态代理
        Object bean = CglibProxyPostProcessor.createProxy(beanClass, name);
        if (bean != null) {
            return bean;
        }

        bean = doCreateBean(name, definition);

        return bean;
    }

    private static Object doCreateBean(String name, RootBeanDefinition definition) throws IllegalAccessException, InstantiationException {


        Class<?> beanClass = definition.getBeanClass();

        // 创建 bean 实例
        Object instanceBean = beanClass.newInstance();

        // 如果正在创建，在加入
        if (singletonCurrentlyInCreationObjects.contains(name)) {
            synchronized (singletonObjects) {
                if (!singletonObjects.containsKey(name)) {
                    singletonFactories.put(name, () -> CglibProxyPostProcessor.createProxy(beanClass, name));
                    earlySingletonObjects.remove(name);
                }
            }
        }


        // 属性赋值
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {

            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                String needBeanName = field.getName();
                Object needBean = getBean(needBeanName);
                field.setAccessible(true);
                field.set(instanceBean, needBean);
            }
        }

        // 初始化，略


        // 若当前类出现了循环依赖，则……
        return getSingleton(name);
    }

    private static Object getBean(String name) throws InstantiationException, IllegalAccessException {

        Object singleton = getSingleton(name);
        if (singleton != null) {
            return singleton;
        }

        return getSingleton(name, () -> {
            try {
                return createBean(name);
            } catch (IllegalAccessException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static Object getSingleton(String name, ObjectFactory<?> factory) {

        Object singletonObject = singletonObjects.get(name);

        if (singletonObject == null) {

            singletonObject = factory.getObject();

            synchronized (singletonObjects) {
                singletonObjects.put(name, singletonObject);
                singletonFactories.remove(name);
                earlySingletonObjects.remove(name);
            }
        }

        return singletonObject;
    }

    private static Object getSingleton(String name) {

        Object bean = singletonObjects.get(name);

        if (bean == null && singletonCurrentlyInCreationObjects.contains(name)) {

            bean = earlySingletonObjects.get(name);

            synchronized (singletonObjects) {

                if (bean == null) {

                    bean = singletonObjects.get(name);
                    if (bean == null) {

                        ObjectFactory<Object> factory = singletonFactories.get(name);
                        if (factory != null) {

                            bean = factory.getObject();
                            earlySingletonObjects.put(name, bean);
                            singletonCurrentlyInCreationObjects.remove(name);
                        }
                    }
                }
            }
        }

        return bean;
    }

    public static void main(String[] args) throws Exception {

        registerBeanDefinition();

        for (String name : beanDefinitionMap.keySet()) {
            getBean(name);
        }

        A a = (A) getBean("a");

        a.b.say();
        a.b.a.say();

    }


}
