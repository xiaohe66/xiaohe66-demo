package com.xiaohe66.demo.se.oop.interfacedemo;

/**
 * @author xh
 * @date 17-12-19 019
 */
public interface B {
    /**
     * 在接口中定义一个常量，默认加上final关键字
     */
    String JOB = "程序员";

    /**
     * 定义一个抽象方法，默认加上public static
     */
    void sayJob();
}
