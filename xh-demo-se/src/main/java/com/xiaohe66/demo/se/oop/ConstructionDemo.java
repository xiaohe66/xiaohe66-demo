package com.xiaohe66.demo.se.oop;

/**
 * @author xh
 * @date 2017-12-14
 *
 * java构造方法
 * 说明：
 * 构造方法是特殊的方法，一般用于在创建对象时进行初始化
 * 构造方法名与类名同名
 * 没有构造方法时，系统会自动生成一个无参构造方法
 * 有构造方法时，系统不会生成
 * 构造方法可重载，会普通方法的重载一样
 */
public class ConstructionDemo {

    private String name;
    private int age;

    ConstructionDemo(){
        System.out.println("默认的构造方法");
    }

    ConstructionDemo(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("有参构造方法");
    }

    public void say(){
        System.out.println("名称是："+name+"，年龄为"+age);
    }


    public static void main(String[] args) {
        ConstructionDemo demo = new ConstructionDemo();
        demo.say();

        ConstructionDemo demo1 = new ConstructionDemo("小何",22);
        demo1.say();
    }

}
