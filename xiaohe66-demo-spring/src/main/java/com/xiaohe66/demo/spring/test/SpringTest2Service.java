package com.xiaohe66.demo.spring.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xiaohe
 * @since 2022.07.05 10:41
 */
@Service
@Slf4j
public class SpringTest2Service {

    public void sayHello(){
        log.info("hello, I am is Service2");
    }

}
