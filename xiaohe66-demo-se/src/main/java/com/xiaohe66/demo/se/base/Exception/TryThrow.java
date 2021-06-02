package com.xiaohe66.demo.se.base.Exception;

/**
 * @author xiaohe
 * @date 17-08-09 009
 *
 * 在try块中可以抛出异常
 * 在try块中有异常时，抛出异常后会执行finally块
 */
public class TryThrow {
    void test(){
        try{
            System.out.println("try");
            throw new NullPointerException("ex");
        }finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        System.out.println("main start");
        new TryThrow().test();
        System.out.println("main end");
    }
}
