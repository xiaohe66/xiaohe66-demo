package com.xiaohe66.demo.se.string;

/**
 * String类的常用方法盘点
 *
 * @author xh
 * @date 2017-12-17
 */
public class StringDemo2 {

    /**
     * 大小写转换
     */
    static void cast(){
        String str = "I am is boy.";
        String str2 = str.toUpperCase();
        System.out.println(str2);
        String str3 = str2.toLowerCase();
        System.out.println(str3);
    }

    /**
     * 去掉字符串的前后空格
     */
    static void tram(){
        String str = " 我是小何 ";
        System.out.println(str);

        //trim方法，去掉字符串的前后空格
        String str2 = str.trim();

        System.out.println(str2);

    }

    /**
     * index方法和index相关的方法可以获取子串在主串中的下标位置
     * 在主串中无子串时，会回返-1
     */
    static void index(){
        String str = "我比较小，大家可以叫我小何";
        //从字符串的开头到结尾遍历查询子串
        int index = str.indexOf("小");
        System.out.println(index);
        //从字符串结尾到开头遍历查询子串
        int index2 = str.lastIndexOf("小");
        System.out.println(index2);
    }

    /**
     * 字符串截取
     */
    static void sub(){
        String str = "我比较小，大家可以叫我小何";
        //从第5到结尾
        String str2 = str.substring(5);
        System.out.println(str2);

        //从第5到第7
        String str3 = str.substring(5,7);
        System.out.println(str3);

    }


    public static void main(String[] args) {
        cast();
        tram();
        index();
        sub();
    }
}
