package com.xiaohe66.demo.se.base;

/**
 * @author xiaohe
 * @time 2019.08.15 15:19
 */
public class BaseTypeConvert {


    public static void main(String[] args) {

        int a = 9;
        int b = 2;

        double c = a * 1.0 / b;
        System.out.println(c);

        double d = ((double) a) / b;
        System.out.println(d);

        double e = (double) a / b;
        System.out.println(e);

    }

}
