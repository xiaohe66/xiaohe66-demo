package com.xiaohe66.demo.se.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程的取消机制
 *
 * @author xiaohe
 * @since 2022.11.10 14:11
 */
public class ThreadPoolExecutorCancelDemo {

    private static final Logger log = LoggerFactory.getLogger(ThreadPoolExecutorCancelDemo.class);

    private static ThreadPoolExecutor threadPoolExecutor;

    static {
        initThreadPoolExecutor();
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            log.info("线程执行 : {}", Thread.currentThread().getName());
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                log.info("线程中断 : {}", Thread.currentThread().getName(), e);
                Thread.currentThread().interrupt();
            }
            log.info("线程结束 : {}", Thread.currentThread().getName());
        };

        // 第1个线程
        Future<?> future = threadPoolExecutor.submit(runnable);

        // 提交的这个线程会在第1个线程取消后执行
        threadPoolExecutor.execute(runnable);

        Thread.sleep(1000);

        // 取消线程执行。若线程还未执行，则直接取消。若线程已执行，且参数为 true 时，调用线程的 interrupt() 方法中断执行。
        future.cancel(true);

        log.info("主线程完毕");
    }


    public static void initThreadPoolExecutor() {

        int workThreadQty = 1;

        ArrayBlockingQueue<Runnable> analyseQueryWorkerQueue = new ArrayBlockingQueue<>(workThreadQty);

        threadPoolExecutor = new ThreadPoolExecutor(workThreadQty, workThreadQty, 0L, TimeUnit.MINUTES, analyseQueryWorkerQueue, createThreadFactory());
    }

    public static ThreadFactory createThreadFactory() {

        AtomicInteger index = new AtomicInteger();
        return r -> new Thread(r, "线程-" + index.getAndIncrement());
    }

}
