package com.xiaohe66.demo.spring.source.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @since 2021.08.24 15:16
 */
@Configuration
public class AopV1Config {

    @Bean
    public People people() {
        return new People();
    }

    @Bean
    public PeopleBeforeAdvice peopleBeforeAdvice() {
        return new PeopleBeforeAdvice();
    }

    @Bean
    public PeopleMethodInterceptor peopleMethodInterceptor() {
        return new PeopleMethodInterceptor();
    }

    @Bean
    public ProxyFactoryBean peopleProxy() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();

        // 这里指定切面，未指定的话，则不会增强
        proxyFactoryBean.setInterceptorNames("peopleBeforeAdvice", "peopleMethodInterceptor");
        proxyFactoryBean.setTarget(people());
        return proxyFactoryBean;
    }

}
