package com.xiaohe66.demo.se.oop.olymorphismdemo;

/**
 * 多态
 *
 * 引入多态的概念：
 * 如main方法中注释的代码块所示，
 * 当数量多了之后，便显得太麻烦了
 * 于是用可以写一个公用的方法进行say动作
 * 而多态，可以用父类的方法指向子类的实现
 *
 * 实现多态的主要步骤
 * 1.定义父类
 * 2.重写父类的方法
 * 3.实例化子类时，用父类的引用进行接收
 *
 *
 * @author xh
 * @date 17-12-19 019
 */
public class Test {
    public static void main(String[] args) {
        /*Super su = new Super();
        su.say();
        Dog dog = new Dog();
        dog.say();
        Cat cat = new Cat();
        cat.say();*/
        say(new Super());
        say(new Dog());
        say(new Cat());
    }

    static void say(Super s){
        s.say();
    }
}
