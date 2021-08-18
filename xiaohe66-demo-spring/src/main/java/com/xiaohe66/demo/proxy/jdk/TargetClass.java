package com.xiaohe66.demo.proxy.jdk;

/**
 * @author xiaohe
 * @since 2021.08.18 18:37
 */
public class TargetClass implements TargetClassSuper {

    @Override
    public void say() {
        System.out.println("我是被增强的类");
    }
}
