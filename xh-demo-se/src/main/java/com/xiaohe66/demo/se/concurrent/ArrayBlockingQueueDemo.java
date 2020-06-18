package com.xiaohe66.demo.se.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 由数组支持的有界队列
 *
 * @author xiaohe
 * @time 2020.06.12 12:43
 */
public class ArrayBlockingQueueDemo {

    /**
     * 定长条件队列，底层实现方式是数组
     * 初始化时传入一个长度，第2个参数是指定是否为公平锁
     */
    static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {


        /*
         * 程序运行之后，可以看到put和get是交替执行的
         */

        int n = 100;
        new Thread(() -> {

            Random random = new Random(System.currentTimeMillis());
            for (int i = 0; i < n; i++) {
                try {
                    int time = random.nextInt(5) * 100;
                    Thread.sleep(time);
                    queue.put(i);
                    System.out.println("put:" + i);
                } catch (InterruptedException e) {
                    System.err.println("put失败:" + i);
                }
            }

        }).start();

        new Thread(() -> {

            Random random = new Random(System.currentTimeMillis());

            for (int i = 0; i < n; i++) {
                try {
                    int time = random.nextInt(5) * 100;
                    Thread.sleep(time);
                    Integer take = queue.take();
                    System.out.println(String.format("第%s次get:%s", i, take));
                } catch (InterruptedException e) {
                    System.err.println("第" + i + "次get失败");
                }
            }

        }).start();


    }

}
