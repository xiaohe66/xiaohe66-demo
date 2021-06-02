package com.xiaohe66.demo.se.oop;

/**
 * @author xh
 * @date 2017-12-13
 *
 * 面象对象，万物皆对象
 * 面向对象主要有以下几种特性
 * 1、封装
 *      将类中实现的过程封装起来，只对外暴露一些接口，来实现模块化，组建化和安全性。
 * 2、继承
 *      子类可以使用父类的属性或接口，实现可扩展性
 * 3、多态
 *      父类的接口可以指向子类的引用
 *
 * 本例中，定义了一个MyObject类
 * 需要注意的是，文件名和类名必须一致
 */
public class MyObject {

    /**
     * 定义类的属性
     */
    String name;

    /**
     * 定义类的方法
     */
    void printName(){
        System.out.println("name="+name);
    }

    public static void main(String[] args) {
        //MyObject是一个类，是抽象的。要创建对象，需要通过new进行创建，这里创建了myObject对象
        MyObject myObject = new MyObject();
        myObject.name = "小何";
        myObject.printName();
    }

}
