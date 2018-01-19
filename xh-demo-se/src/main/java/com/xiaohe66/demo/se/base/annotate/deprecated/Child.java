package com.xiaohe66.demo.se.base.annotate.deprecated;

/**
 * @author xiaohe
 * @date 16-12-20 020
 *
 */
public class Child implements Person{
    /*
     * @Override 注解表示了该方法重写的父类的方法
     */
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void sing() {

    }

    public static void main(String[] args){
        Person child = new Child();
        //使用@Deprecated表示该方法已过时
        child.sing();
    }
}
