package com.xiaohe66.demo.se.jvm;

/**
 * 对象栈上分配
 *
 * <p>
 * 逃逸分析： -XX:+DoEscapeAnalysis
 * 标量替换： -XX:+EliminateAllocations
 *
 * <p>
 * 使用如下参数不会发生GC
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations -XX:+PrintGCDetails
 *
 * <p>
 * 使用如下参数都会发生大量GC
 * -Xmx15m -Xms15m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations -XX:+PrintGCDetails
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations -XX:+PrintGCDetails
 *
 * @author xiaohe
 * @time 2020.11.02 14:50
 */
public class StackAllocationDemo {

    private int id;
    private String name;

    public static void main(String[] args) {

        // 创建这n个对象的内存超过1G，在堆15M的情况下，必定会发生GC
        int n = 1024 * 1024;

        for (int i = 0; i < n; i++) {
            test();
        }
    }

    private static void test() {
        StackAllocationDemo demo = new StackAllocationDemo();
        demo.id = 1;
        demo.name = "he";
    }

}
