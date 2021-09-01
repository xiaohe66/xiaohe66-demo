package com.xiaohe66.demo.spring.source.aop.source;

import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @since 2021.08.24 11:19
 */
@Component
public class TestBean {

    public String doSth() {
        System.out.println("bean方法执行");
        return String.valueOf(System.currentTimeMillis());
    }

}
