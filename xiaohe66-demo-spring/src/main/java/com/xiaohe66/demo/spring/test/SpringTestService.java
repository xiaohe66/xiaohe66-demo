package com.xiaohe66.demo.spring.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author xiaohe
 * @since 2022.07.05 10:14
 */
@Service
@RequiredArgsConstructor
public class SpringTestService {

    private final SpringTestMapper springTestMapper;
    private final SpringTest2Service springTest2Service;

    public String query() {

        springTest2Service.sayHello();

        return springTestMapper.query();
    }

    public String query2() {

        springTest2Service.sayHello();

        return springTestMapper.query2();
    }

}
