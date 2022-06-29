package com.xiaohe66.demo.se.spi;

/**
 * 模拟外部扩展SPI的接口
 *
 * @author xiaohe
 * @since 2022.06.29 14:40
 */
public class MySpiInterfaceImpl implements MySpiInterface {

    @Override
    public void test() {
        System.out.println("hello spi");
    }
}
