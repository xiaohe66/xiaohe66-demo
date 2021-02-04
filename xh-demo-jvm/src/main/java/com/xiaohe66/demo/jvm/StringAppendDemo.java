package com.xiaohe66.demo.jvm;

/**
 * 字符串拼接字节码分析
 *
 * @author xiaohe
 * @time 2020.11.02 18:15
 */
public class StringAppendDemo {


    public void test1(){

        int i = 1;
        String str = i + "";

        System.out.println(str);

    }

    public void test2(){

        int i = 1;
        String str = String.valueOf(i);

        System.out.println(str);
    }

    public static void main(String[] args) {

        StringAppendDemo demo = new StringAppendDemo();

        demo.test1();
        demo.test2();

    }


}
