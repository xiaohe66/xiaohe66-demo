package com.xiaohe66.demo.spring.source.aop;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @since 2021.08.24 16:26
 */
@Configuration
public class AopV3Config {

    /**
     * 注意这里的 beanName 改变了，
     * 由 BeanNameAutoProxyCreator自动生成的代理的beanName 为 bean原始的名称
     */
    @Bean
    public People peopleProxy() {
        return new People();
    }

    @Bean
    public PeopleBeforeAdvice peopleBeforeAdvice() {
        return new PeopleBeforeAdvice();
    }

    /**
     * 自动生成 bean 的代理，而不需要自己指定
     *
     * @see DefaultAdvisorAutoProxyCreator 使所有的 Advice生效，而无需其它配置
     */
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {

        BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
        creator.setBeanNames("people");
        creator.setInterceptorNames("peopleBeforeAdvice");

        return creator;
    }

}
