package com.xiaohe66.demo.spring.test;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class SpringTestMockTest {

    @InjectMocks
    private SpringTestService springTestService;

    @Mock
    private SpringTestMapper springTestMapper;

    /**
     * 虽然被 @Service 修饰了，但是未被 Spring 容器加载，因此需要 Mock。可以考虑 Spring-test 的实现
     */
    @Mock
    private SpringTest2Service springTest2Service;

    @Test
    public void test1() {

        String correctValue = "mock value";

        MockitoAnnotations.openMocks(this);

        // mock 指定方法的返回值。SpringTestMapper 是一个接口，本来是没有返回值的。
        Mockito.when(springTestMapper.query()).thenReturn(correctValue);

        String ret = springTestService.query();

        assertEquals(correctValue, ret);
    }
}
