package com.xiaohe66.demo.se.oop;

/**
 * 代码块
 *
 * 构造代码块、静态代码块
 *
 * @author xh
 * @date 2017-12-17
 */
public class CodeBlock {
    /**
     * 通用构造块，在任意一个构造方法执行前执行，一般用于通用的初始化
     */
    {
        System.out.println("通用构造块");
    }

    /**
     * 静态代码块，在类加载时执行
     */
    static {
        System.out.println("静态代码块");
    }
    CodeBlock(){
        System.out.println("无参构造方法");
    }
    CodeBlock(int a){
        System.out.println("带参构造方法1");
    }
    CodeBlock(long a){
        System.out.println("带参构造方法2");
    }

    public static void main(String[] args) {
        new CodeBlock();
        new CodeBlock(1);
        new CodeBlock(1L);
    }

}
