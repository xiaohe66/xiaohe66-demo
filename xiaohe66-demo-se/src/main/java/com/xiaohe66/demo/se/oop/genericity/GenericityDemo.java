package com.xiaohe66.demo.se.oop.genericity;

/**
 * 泛型
 * 编译时生效
 * 用于限定类型
 *
 * @author xh
 * @date 17-12-20 020
 */
public class GenericityDemo {

    /**
     * 泛型方法
     * @param t 任意类型的参数
     * @param <T> ……
     */
    public <T> void f(T t){
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        GenericityDemo genericityDemo = new GenericityDemo();
        genericityDemo.f(1);
        genericityDemo.f('a');
        genericityDemo.f("");
    }
}
