package com.xiaohe66.demo.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xiaohe
 * @since 2022.07.05 10:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringBootApplicationTest.SpringTestConfig.class})
public class SpringBootApplicationTest {

    @Autowired
    private SpringTestService springTestService;

    /**
     * 替换 spring 中的bean，使 mock 的对象加入 spring 容器中
     */
    @MockBean
    private SpringTestMapper springTestMapper;

    @Before
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test1() {

        String correctValue = "mock value";

        // mock 指定方法的返回值。SpringTestMapper 是一个接口，本来是没有返回值的。
        Mockito.when(springTestMapper.query()).thenReturn(correctValue);

        String query = springTestService.query();

        System.out.println(query);
    }

    @ComponentScan(basePackageClasses = SpringTestService.class)
    public static class SpringTestConfig {

    }
}
