package com.xiaohe66.demo.spring.source.postprocessor;

import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @time 2021.08.03 16:02
 */
@Component
public class PostProcessorTestService {

    public PostProcessorTestService() {
        System.out.println("Car初始化");
    }
}
