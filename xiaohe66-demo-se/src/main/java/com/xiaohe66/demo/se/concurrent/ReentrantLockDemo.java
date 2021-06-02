package com.xiaohe66.demo.se.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁
 *
 * @author xiaohe
 * @time 2020.06.02 10:38
 */
public class ReentrantLockDemo {

    // 公平锁，传入false时为非公平锁
    private ReentrantLock lock = new ReentrantLock();

    private int count;

    private void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockDemo demo = new ReentrantLockDemo();
        int n = 1000;

        Runnable runnable = () -> {
            for (int i = 0; i < n; i++) {
                demo.increment();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(demo.count);
    }
}
