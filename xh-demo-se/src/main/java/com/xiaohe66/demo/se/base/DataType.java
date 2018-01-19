package com.xiaohe66.demo.se.base;

/**
 * @author xh
 * @date 2017-12-9
 *
 * java基础数据类型
 */
public class DataType {

    /**
     * 整数类型
     */
    public static void integerType(){
        int     data1 = 1;
        short   data2 = 2;
        long    data3 = 3;
        byte    data4 = 4;
        System.out.println("-----------整数类型------------");
        System.out.println("int类型："+data1);
        System.out.println("short类型："+data2);
        System.out.println("long类型："+data3);
        System.out.println("byte类型："+data4);
        System.out.println("-----------整数类型end---------");
    }

    /**
     * 浮点类型
     * 定义小数时，默认是double类型
     * 若需要定义float类型，则需要加上f
     */
    public static void  floatType(){
        float   data1 = 1.0f;
        double  data2 = 2.0;
        System.out.println("-----------浮点类型------------");
        System.out.println("float类型："+data1);
        System.out.println("double类型："+data2);
        System.out.println("-----------浮点类型end---------");
    }

    /**
     * 布尔类型
     */
    public static void booleType(){

        boolean data1 = true;
        System.out.println("-----------布尔类型------------");
        System.out.println("布尔类型："+data1);
        System.out.println("-----------浮点类型end---------");
    }

    /**
     * 字符类型
     */
    public static void charType(){
        //字符类型用单引号定义
        char data1 = '1';
        //字符串类型
        String data2 = "2";
        System.out.println("-----------字符类型------------");
        System.out.println("char类型："+data1);
        System.out.println("String类型："+data2);
        System.out.println("-----------字符类型end---------");
    }


    public static void main(String[] args) {

        integerType();
        floatType();
        booleType();
        charType();

    }
}
