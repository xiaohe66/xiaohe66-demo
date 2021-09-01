package com.xiaohe66.demo.spring.source.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @since 2021.08.24 16:03
 */
@Configuration
public class AopV2Config {

    @Bean
    public People people() {
        return new People();
    }

    @Bean
    public PeopleBeforeAdvice peopleBeforeAdvice() {
        return new PeopleBeforeAdvice();
    }

    /**
     * 使用 NameMatchMethodPointcutAdvisor 可以指定切入的方法名称
     * 只有方法名称匹配时，才会切入
     *
     * @see RegexpMethodPointcutAdvisor 正则表达式
     */
    @Bean
    public NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor() {

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setAdvice(peopleBeforeAdvice());
        advisor.setMappedNames("say");

        return advisor;
    }

    @Bean
    public ProxyFactoryBean peopleProxy() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();

        // 这里指定的是 NameMatchMethodPointcutAdvisor，而不是 BeforeAdvice
        // 若同时指定了这2个，则 BeforeAdvice 会被调用 2次
        proxyFactoryBean.setInterceptorNames("nameMatchMethodPointcutAdvisor");
        proxyFactoryBean.setTarget(people());
        return proxyFactoryBean;
    }

}
