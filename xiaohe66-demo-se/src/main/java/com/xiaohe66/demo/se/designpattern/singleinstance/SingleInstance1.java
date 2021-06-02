package com.xiaohe66.demo.se.designpattern.singleinstance;

/**
 * @author xh
 * @date 2017-12-6
 */
public class SingleInstance1 {

    private static SingleInstance1 singleInstance1 = new SingleInstance1();

    private SingleInstance1(){}

    public static SingleInstance1 getInstance(){
        return singleInstance1;
    }

}
