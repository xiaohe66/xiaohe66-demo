package com.xiaohe66.demo.spring.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

/**
 * Spring Boot 的测试
 *
 * {@link SpringBootTest} 注解表示 Spring Boot 测试，会加载相关的 Bean，其中的 classes 参数表示扫描的表
 * {@link  AutoConfigureMockMvc} 注解表示使用 MockMvc
 *
 * @author xiaohe
 * @since 2022.07.05 10:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootApplicationTest.SpringTestConfig.class})
@AutoConfigureMockMvc
@Slf4j
class SpringBootApplicationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private SpringTestService springTestService;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 替换 spring 中的bean，使 mock 的对象加入 spring 容器中
     *
     * 注意：
     * {@link SpyBean} 所有的方法默认调用真实的实现，只有指定的方法会mock
     * {@link org.springframework.boot.test.mock.mockito.MockBean} 所有方法都会被 mock，若不指定实现，则方法会返回空值。
     */
    @SpyBean
    private SpringTestMapper springTestMapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("查询 Mapper 的所有 Bean")
    @Test
    void test0() {
        Map<String, SpringTestMapper> beansOfType = applicationContext.getBeansOfType(SpringTestMapper.class);
        for (Map.Entry<String, SpringTestMapper> entry : beansOfType.entrySet()) {
            log.info("{} : {}", entry.getKey(), entry.getValue());
        }
    }

    @DisplayName("测试1")
    @Test
    void test1() {

        String correctValue = "mock value";

        // mock
        Mockito.when(springTestMapper.query()).thenReturn(correctValue);

        // NOTE ： 由于Mapper是一个接口，因此 MOCK 无法调用原本的实现
        // Mockito.when(springTestMapper.query()).thenCallRealMethod();

        String correctValue2 = "origin-2";

        String queryRet = springTestService.query();
        String query2ret = springTestService.query2();

        Assertions.assertEquals(correctValue, queryRet);
        Assertions.assertEquals(query2ret, correctValue2);
    }

    @ComponentScan(basePackageClasses = SpringTestService.class)
    public static class SpringTestConfig {

    }
}
