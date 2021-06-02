package com.xiaohe66.demo.se.jvm.gc;

/**
 * 研究栈溢出代码
 *
 * <p>通过递归调用，使得栈的内存得不到回收，在达到一定次数后，便出现栈溢出
 *
 * @author xiaohe
 * @time 2020.06.23 10:19
 */
public class StackOverflowDemo {

    static int count;

    static void redo() {
        count++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("栈溢出, count = " + count);
        }
    }
}
