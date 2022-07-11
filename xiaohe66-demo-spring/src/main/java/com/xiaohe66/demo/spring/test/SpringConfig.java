package com.xiaohe66.demo.spring.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @since 2022.07.11 10:43
 */
@Configuration
public class SpringConfig {

    @Bean
    public FactoryBean<SpringTestMapper> springTestMapper() {

        SpringTestMapper bean = new SpringTestMapper() {

            @Override
            public String query() {
                return "origin";
            }

            @Override
            public String query2() {
                return "origin-2";
            }
        };

        return new FactoryBean<SpringTestMapper>() {
            @Override
            public SpringTestMapper getObject() throws Exception {
                return bean;
            }

            @Override
            public Class<?> getObjectType() {
                return SpringTestMapper.class;
            }
        };
    }

}
