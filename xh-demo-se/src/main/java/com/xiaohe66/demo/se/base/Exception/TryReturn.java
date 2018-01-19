package com.xiaohe66.demo.se.base.Exception;

/**
 * @author xiaohe
 * @date 17-08-09 009
 *
 * 当try块中有return时，会先执行完finally中的代码，再进行return
 */
public class TryReturn {
    void test(){
        try{
            System.out.println("try");
            return;
        }finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        System.out.println("main start");
        new TryReturn().test();
        System.out.println("main end");
    }
}
