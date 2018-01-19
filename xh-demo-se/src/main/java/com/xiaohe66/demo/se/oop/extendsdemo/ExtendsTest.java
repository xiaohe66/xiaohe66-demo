package com.xiaohe66.demo.se.oop.extendsdemo;

/**
 * 继承
 * 子类继承父类后，可以使用非私有的属性和方法
 * java只支持单继承
 *
 * @author xh
 * @date 17-12-19 019
 */
public class ExtendsTest {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("大猫");
        cat.setAge(2);
        cat.say();

        new Cat("小猫",1).say();
    }
}
