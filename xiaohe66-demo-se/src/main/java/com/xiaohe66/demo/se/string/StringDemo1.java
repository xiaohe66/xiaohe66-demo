package com.xiaohe66.demo.se.string;

/**
 * 创建String对象的方式和区别
 * 1、直接赋值：
 *      创建的对象存放在对象池中。
 *      若准备创建的对象已存在于对象池中，就不会创建新的对象，而是直接返回已存在对象的引用。
 * 2、使用new：
 *      每次都创建一个新的对象。
 *
 * ==和equals的区别
 * ==    :
 *      值比较
 *      比较对象的内存地址/值
 * equals：
 *      逻辑比较
 *      调用对象的equals方法，进行逻辑运算，并获取返回值
 *
 *
 * @author xh
 * @date 2017-12-17
 */
public class StringDemo1 {
    public static void main(String[] args) {
        String str1 = "小何";
        String str2 = "小何";

        /*
         * 值比较，直接赋值方式
         * 因为在创建已存在的String对象时，会直接返回该对象的引用
         * 因此，str1和str2的内在地址是相同的
         */
        System.out.println("str1==str2:"+(str1==str2));
        /*
         * 逻辑比较，因为字符串相同，因此结果为true
         */
        System.out.println("str1.equals(str2):"+str1.equals(str2));

        String str3 = new String("小何");
        String str4 = new String("小何");

        /*
         * 使用new创建String对象时，都是创建新对象，
         * 因此str3和str4的引用不同，故结果为false
         */
        System.out.println("str3==str4:"+(str3==str4));
        /*
         * 逻辑比较字符串相同，结果为true
         */
        System.out.println("str3.equals(str4):"+(str3.equals(str4)));

    }
}
