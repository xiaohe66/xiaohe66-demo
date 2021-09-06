package com.xiaohe66.demo.se.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * <p>
 * 适用场景：读多写少时
 * 读读共享、读写互斥
 * 1. 有线程获取了读锁，其它线程也可以获得写锁
 * 2. 有线程获取了读锁，其它线程获取写锁会被阻塞
 * 3. 有线程获取了写锁，其它线程获取读锁和写锁会被阻塞
 *
 * @author xiaohe
 * @since 2021.09.06 10:33
 */
public class ReentrantReadWriteLockDemo {

    private ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock();
    private ReentrantLock lock = new ReentrantLock();

    private int sum;

    public void read() {
        // 注释这一行，测试普通的锁
        Lock lock = this.writeLock.readLock();
        lock.lock();
        try {
            // 正常的程序都会有一点的延迟，这里睡1秒进行模拟
            sleep(1);
            System.out.println("sum : " + sum);
        } finally {
            lock.unlock();
        }
    }

    public void write() {
        // 注释这一行，测试普通的锁
        Lock lock = this.writeLock.writeLock();
        lock.lock();
        try {
            // 正常的程序都会有一点的延迟，这里睡1秒进行模拟
            sleep(1);
            sum++;

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int readThreadQty = 10;
        int readQty = 1000;
        int writeQty = 10;

        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        CountDownLatch countDownLatch = new CountDownLatch(readThreadQty + 1);

        long currentTime = System.currentTimeMillis();

        // 读线程
        for (int i = 0; i < readThreadQty; i++) {
            new Thread(() -> {
                sleep(1000);
                for (int j = 0; j < readQty; j++) {
                    demo.read();
                }
                countDownLatch.countDown();
            }).start();
        }

        // 写线程
        new Thread(() -> {
            sleep(1000);
            for (int j = 0; j < writeQty; j++) {
                sleep(10);
                demo.write();
            }
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        // 最终输出，判断最终值是否正确
        demo.read();

        System.out.println(System.currentTimeMillis() - currentTime);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
