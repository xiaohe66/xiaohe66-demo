package com.xiaohe66.demo.jvm;

/**
 * 设置初始的元空间大小为1M，方便示例
 * -XX:+PrintGC -XX:+PrintGCDetails -XX:MetaspaceSize=1M -XX:MaxMetaspaceSize=256M
 * <p>
 * 最终可以观察到，因元空间不足，而造成了 Full gc
 * <p>
 * 建议：直接设置元空间最小值等于最大值即可，如 256M
 *
 * @author xiaohe
 * @time 2020.11.02 15:32
 */
public class MetaspaceGcDemo {


    public static void main(String[] args) {

        System.out.println("hello");

    }

}
