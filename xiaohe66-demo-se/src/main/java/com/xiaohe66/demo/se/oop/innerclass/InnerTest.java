package com.xiaohe66.demo.se.oop.innerclass;

/**
 * @author xh
 * @date 2017-12-17
 */
public class InnerTest {

    public static void main(String[] args) {
        //创建外部类对象
        Outer outer = new Outer();
        //创建内部类对象
        Outer.Inner inner = outer.new Inner();

        inner.say();
    }
}
