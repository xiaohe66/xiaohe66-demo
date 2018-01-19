package com.xiaohe66.demo.se.oop.instanceofdemo;

/**
 * instanceof关键字
 * 该关键字可以判断某个实例是否为某个类的实例
 *
 * @author xh
 * @date 17-12-20 020
 */
public class Son extends Super{
    public static void main(String[] args) {
        Super s = new Son();
        Super s2 = new Super();
        System.out.println(s instanceof Son);
        System.out.println(s2 instanceof Son);
    }
}
