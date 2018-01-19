package com.xiaohe66.demo.se.designpattern.factory;

/**
 * @author xh
 * @date 2017-12-6
 */
public class Factory {
    private static volatile Factory factory;

    private Factory(){}

    public static Factory getInstance(){
        if(factory == null){
            synchronized (Factory.class){
                if(factory == null){
                    factory = new Factory();
                }
            }
        }
        return factory;
    }



}
