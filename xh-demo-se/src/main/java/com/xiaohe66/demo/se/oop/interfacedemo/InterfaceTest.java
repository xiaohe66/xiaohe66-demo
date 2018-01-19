package com.xiaohe66.demo.se.oop.interfacedemo;

/**
 * 接口
 *
 * 要点：
 * 1.接口中的属性默认都是常量
 * 2.接口中的方法默认都是抽象方法，且为访问权限为public，并且是static的
 * 3.java支持实现多个接口
 *
 * @author xh
 * @date 17-12-19 019
 */
public class InterfaceTest implements A,B {

    @Override
    public void sayJob() {
        System.out.println("我的工作是："+ JOB);
    }

    @Override
    public void sayName() {
        System.out.println("我的名字是："+ NAME);
    }

    public static void main(String[] args) {
        //访问接口中的常量
        System.out.println(NAME);
        System.out.println(JOB);

        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.sayName();
        interfaceTest.sayJob();
    }
}
