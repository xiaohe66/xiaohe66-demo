package com.xiaohe66.demo.se.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

/**
 * 定时任务的实现
 *
 * 这种定时任务的优势在于可以随时控制下次执行的时间，（动态调整）
 * 缺点在于无法精确控制执行的间隔
 *
 * @author xiaohe
 * @since 2022.03.11 13:37
 */
public class MyTimer {

    static void run(){
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // do sth.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now());

            // 通过异步来调用自己，不是递归
            run();
        });
    }

    public static void main(String[] args) throws InterruptedException {

        run();
        System.out.println("start");

        // 这种定时任务的实现需要主线程不中断，主线程执行完后会立即退出JVM
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
