package com.xiaohe66.demo.se.designpattern.singleinstance;

/**
 * @author xh
 * @date 2017-12-6
 */
public class SingleInstance2 {

    private static volatile SingleInstance2 singleInstance2;

    private SingleInstance2(){}

    public static SingleInstance2 getInstance(){
        if(singleInstance2 == null){
            synchronized (SingleInstance2.class){
                if(singleInstance2 == null){
                    singleInstance2 = new SingleInstance2();
                }
            }
        }
        return singleInstance2;
    }

}
