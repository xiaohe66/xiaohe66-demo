package com.xiaohe66.demo.se.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiaohe
 * @since 2022.06.15 11:19
 */
public class LinkedBlockingQueueBug {

    /*
    * LinkedBlockingQueue 的一个线程安全 Bug，修复于JDK9，
    * 代码取自 https://juejin.cn/post/7108579726066712589#heading-2
    * 该Bug在JDK上也提出过：https://bugs.openjdk.org/browse/JDK-8171051
    * Bug的现象是 stream 的操作造成了死循环。
    * */

    public static void main(String[] args)throws Exception {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue <>(1000);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    queue.offer(new Object());
                    queue.remove();
                }
            }).start();
        }
        while (true) {
            // 若没有问题，则会交替打印开始和结束的两条输出。
            // 但结果是，只打印一次，或交替打印几次就停了。原因是陷入了死循环。
            // 该Bug修复于 JDK9，可切换到高版本JDK尝试。
            System.out.println("beginscan,istillalive");
            queue.stream()
                    .filter(o -> o == null)
                    .findFirst()
                    .isPresent();
            Thread.sleep(100);
            System.out.println("finishscan,istillalive");
        }
    }


}
