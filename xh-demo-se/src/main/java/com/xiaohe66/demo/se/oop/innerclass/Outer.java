package com.xiaohe66.demo.se.oop.innerclass;

/**
 * @author xh
 * @date 2017-12-17
 */
public class Outer {

    private int a = 1;

    class Inner{
        public void say(){
            //内部类可以方便的访问外部类的属性
            System.out.println("a="+a);
        }
    }

    public void say(){
        //创建内部类对象
        Inner inner = new Inner();
        //调用内部类对象的方法
        inner.say();
    }
}
