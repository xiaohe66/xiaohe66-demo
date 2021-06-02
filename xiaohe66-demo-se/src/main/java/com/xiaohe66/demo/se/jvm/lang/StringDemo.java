package com.xiaohe66.demo.se.jvm.lang;

/**
 * @author xiaohe
 * @time 2020.07.20 14:16
 */
public class StringDemo {


    private static void test1() {
        String s1 = new String("xiaohe");
        String s2 = s1.intern();

        // 结果为false, s1为堆中的一个对象，而intern()返回的是字符串常量池中 xiaohe 的引用
        System.out.println(s1 == s2);
    }

    private static void test2() {
        String s1 = "xiaohe";
        String s2 = new String("xiaohe");

        // 结果为false, s1是字符串常量池中 xiaohe 的引用，s2是堆中的一个对象
        System.out.println(s1 == s2);
    }

    private static void test3() {
        String s1 = "xiaohe";
        // 在编译期就可以确定最终值，因此会被jvm优化成 xiaohe
        // 相当于 String s2 = "xiaohe";
        String s2 = "xiao" + "he";

        System.out.println(s1 == s2); // true
    }

    private static void test4() {
        String s1 = "xiaohe";
        String s2 = "he";

        // 在编译期时，由于 s2 是个变量，是个不确定值，因此无法被JVM优化，
        // 若在 s2 前面加 final 修饰，则可以被JVM优化
        String s3 = "xiao" + s2;

        System.out.println(s1 == s3); // false
    }

    private static void test6() {

        // 字符串常量池中创建了2个缓存(xiao、he66)
        // 堆中创建了3个对象(xiao、he66、xiaohe66)，其中只有 xiaohe66 被s1引用着
        String s1 = new String("xiao") + new String("he66");

        /*
         * JDK 1.6 常量池中不存在，因此在常量池创建 xiaohe66 ，然后返回这个新创建的缓存的引用
         * JDK 1.7 常量池中不存在，因此在常量池中创建一个引用，则引用指向 s1
         *
         */
        String s2 = s1.intern();

        //  1.6 结果为 false
        //  1.7 结果为 true
        System.out.println(s1 == s2);
    }

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
//        test4();
        test6();
    }

}
