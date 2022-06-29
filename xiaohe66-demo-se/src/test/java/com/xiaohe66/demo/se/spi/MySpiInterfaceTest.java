package com.xiaohe66.demo.se.spi;

import org.junit.Test;

import java.util.ServiceLoader;

public class MySpiInterfaceTest {

    @Test
    public void test1() {

        // 加载所有的 SPI 实现
        ServiceLoader<MySpiInterface> list = ServiceLoader.load(MySpiInterface.class);

        // SPI 的实现只能全部遍历，但实际上可能只需要一个。因此最佳实践是在接口中增加一个匹配方法，用于区分不同的SPI实现。
        for (MySpiInterface impl : list) {

            impl.test();
        }
    }
}
