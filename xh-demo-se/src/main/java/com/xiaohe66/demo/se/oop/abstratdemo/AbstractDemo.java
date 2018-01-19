package com.xiaohe66.demo.se.oop.abstratdemo;

/**
 * 抽象类
 * 抽象类一般用作模板，在抽象类中实现已知的业务，一些未知的方法交给子类实现
 *
 * 要点：
 * 1.抽象类不能被实例化
 * 2.使用abstract关键字定义类和抽象方法
 * 3.抽象类可以有普通方法，也可以没有抽象方法
 * 4.抽象类的直接非抽象子类必须实现所有抽象方法
 *
 * @author xh
 * @date 17-12-19 019
 */
public abstract class AbstractDemo {

    private String name;

    public AbstractDemo(String name){
        this.name = name;
    }

    public void sayName(){
        System.out.println("我的名字是："+name);
    }

    /**
     * 定义一个抽象方法，该方法需要子类实现
     */
    public abstract void sayJob();
}
