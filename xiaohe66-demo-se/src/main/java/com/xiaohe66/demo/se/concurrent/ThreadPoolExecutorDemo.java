package com.xiaohe66.demo.se.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池 demo
 * 手动创建线程池 demo
 *
 * @author xiaohe
 * @since 2021.09.02 13:45
 */
public class ThreadPoolExecutorDemo {

    private ThreadPoolExecutor executor;

    private ThreadPoolExecutorDemo() {

        // 核心线程数量
        int corePoolSize = 2;

        // 最大线程数量
        int maximumPoolSize = 5;

        // 空闲线程的存活时间
        long keepAliveTime = 2;

        // 空闲线程的存活时间的单位
        TimeUnit unit = TimeUnit.SECONDS;

        // 用于存放任务的队列，可以称之为工作队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);

        AtomicInteger index = new AtomicInteger();

        // 线程工厂，用于创建线程。目的是为了自己指定线程的名称
        ThreadFactory threadFactory = r -> new Thread(r, "线程-" + index.getAndIncrement());

        // 用于处理被拒绝的任务
        RejectedExecutionHandler handler = (r, executor2) -> {

            System.out.println("任务被拒绝");

            MyRunning myRunning = (MyRunning) r;
            myRunning.countDownLatch.countDown();
        };

        executor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutorDemo demo = new ThreadPoolExecutorDemo();

        int count = 20;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {

            demo.executor.execute(new MyRunning(countDownLatch, i));
        }
        countDownLatch.await();

        // 重置
        countDownLatch = new CountDownLatch(count);

        // 当前线程池指定了空闲2秒会销毁，这里休眠3秒，保证其销毁
        Thread.sleep(3000);
        System.out.println("------------------------------");

        for (int i = 0; i < count; i++) {

            demo.executor.execute(new MyRunning(countDownLatch, i));
        }
        countDownLatch.await();

        demo.executor.shutdown();
    }


    private static class MyRunning implements Runnable {

        CountDownLatch countDownLatch;
        int no;

        public MyRunning(CountDownLatch countDownLatch, int no) {
            this.countDownLatch = countDownLatch;
            this.no = no;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-线程被执行 :" + no);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}
