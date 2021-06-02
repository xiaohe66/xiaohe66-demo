package com.xiaohe66.demo.se.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 限流器
 *
 * @author xiaohe
 * @time 2020.06.02 13:55
 */
public class SemaphoreDemo {

    // 第2个参数传入true时为公平的，false为非公平，默认为非公平
    Semaphore semaphore = new Semaphore(4);


    void run() {
        String name = Thread.currentThread().getName();
        try {
            // 阻塞并获得许可，可以指定数量，默认为1
            semaphore.acquire(2);
            // 伪代码，表示业务逻辑执行过了1秒
            System.out.println(String.format("线程%s获得信号量", name));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.err.println(String.format("线程%s释放", name));

        // 释放许可
        semaphore.release(2);
    }


    /**
     * 执行后可以观察到每1秒仅有2个业务请求通过
     *
     * @param args
     */
    public static void main(String[] args) {

        SemaphoreDemo demo = new SemaphoreDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(demo::run).start();
        }

    }
}
