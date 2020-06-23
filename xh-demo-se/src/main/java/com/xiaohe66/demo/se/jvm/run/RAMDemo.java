package com.xiaohe66.demo.se.jvm.run;

/**
 * JVM运行时内存分析程序
 *
 * <P> 分析该类的节点码文件，用于学习java程序在运行时的各种情况（内存分配、计算过程等）
 *
 * @author xiaohe
 * @time 2020.06.22 10:39
 */
public class RAMDemo {

    public int comp() {

        int a = 1;
        int b = 2;
        int c = (a + b) * 10;

        return c;
    }

    public static void main(String[] args) {

        RAMDemo ram = new RAMDemo();
        /*
         * 在这行代码调用中
         * 若该方法是私有的，且不使用该方法的返回结果，则程序在编译时不会编译该方法（等于不执行）
         * note : 可以对比comp方法分别为private和public时的字节码。
         */
        ram.comp();

        System.out.println("test");

    }

}
