package com.xiaohe66.demo.se.oop.abstratdemo;

/**
 * @author xh
 * @date 17-12-19 019
 */
public class Test extends AbstractDemo{

    public Test(String name) {
        super(name);
    }

    /**
     * 子类对抽象类方法的实现
     */
    @Override
    public void sayJob() {
        System.out.println("我的工作是写代码");
    }

    public static void main(String[] args) {
        Test test = new Test("小何");
        test.sayName();
        test.sayJob();
    }
}
