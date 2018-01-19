package com.xiaohe66.demo.se.oop.extendsdemo;

/**
 * 定义一个父类
 *
 * @author xh
 * @date 17-12-19 019
 */
public class Super {
    private String name;
    private int age;

    public Super(){
        System.out.println("父类无参构造方法");
    }

    public Super(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("父类有参构造方法");
    }

    public void say(){
        System.out.println("我是"+name+",我今年"+age+"岁");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
