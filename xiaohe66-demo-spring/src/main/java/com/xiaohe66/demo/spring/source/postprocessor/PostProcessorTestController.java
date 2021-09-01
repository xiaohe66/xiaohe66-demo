package com.xiaohe66.demo.spring.source.postprocessor;

import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @since 2021.08.24 10:17
 */
@Component
public class PostProcessorTestController {

    private final PostProcessorTestService service;

    public PostProcessorTestController(PostProcessorTestService service) {
        this.service = service;
    }
}
