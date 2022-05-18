package com.xiaohe66.demo.spring.importclass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @since 2022.05.18 09:56
 */
@Configuration
public class ImportClassConfigure {

    @Bean
    public Object aBeanObject() {

        System.out.println("自动配置类被自动执行");

        return new Object();
    }

}
