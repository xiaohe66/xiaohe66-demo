package com.xiaohe66.demo.se.oop.extendsdemo;

/**
 * 定义一个子类
 *
 * @author xh
 * @date 17-12-19 019
 */
public class Cat extends Super{

    public Cat(){
        //初始化子类时，会调用父类的构造方法
        // 子类没有显示调用父类的构造方法时，会默认加上super()
        System.out.println("子类无参构造方法");
    }

    public Cat(String name, int age) {
        //子类调用父类的方法，若不显示调用，则会默认加上super()
        super(name, age);
        System.out.println("子类有参构造方法");
    }

}
