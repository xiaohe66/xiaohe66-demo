package com.xiaohe66.demo.se.concurrent;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch这个类能够使一个线程等待其他线程完成各自的工作后再执行。
 * 例如，应用程序的主线程希望在负责启动框架服务的线程已经启动所有的框架服务之后再执行
 *
 * @author xiaohe
 * @time 2020.06.08 14:06
 */
public class CountDownLatchDemo extends Thread {

    private static Random random = new Random(System.currentTimeMillis());

    private final CountDownLatch countDownLatch;

    public CountDownLatchDemo(String name, CountDownLatch countDownLatch) {
        super(name);
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            int sleepS = random.nextInt(5);
            outTime(name + "执行业务预计耗时" + sleepS + "秒");
            Thread.sleep(sleepS * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            outTime(name + "执行完毕");
            countDownLatch.countDown();
        }
    }

    private static void outTime(String msg) {
        System.out.println(String.format("%s-%s", LocalTime.now().toString(), msg));
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        new CountDownLatchDemo("线程1", countDownLatch).start();
        new CountDownLatchDemo("线程2", countDownLatch).start();

        outTime("等待2个线程都执行完毕");
        countDownLatch.await();

        outTime("2个线程都执行完毕，后续业务继续");

    }

}
