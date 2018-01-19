package com.xiaohe66.demo.se.oop;

/**
 * final关键字的使用
 *
 * final表示不可变，主要应用以类、方法和属性中
 * 1.应用在class       表示类不可被继承
 * 2.应用在方法          表示方法不可以被子类重写
 * 3.应用在属性          表示属性不可以重新被赋值
 *
 * @author xh
 * @date 17-12-19 019
 */
public final class FinalDemo {

    /**
     * 定义一个常量，
     * 因为常量是不可变的，因此在每个对象中的值都是一样的，
     * 所以一般都会给常量加上static关键字
     */
    final static int i = 1;

    /**
     * 定义一个final方法，该方法不能被子类重写
     */
    final void testFunc(){

    }

}
