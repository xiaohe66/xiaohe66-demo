package com.xiaohe66.demo.se.concurrent;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏屏障，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程
 * 到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。
 * CyclicBarrier默认的构造方法是CyclicBarrier（int parties），其参数表示屏障拦截的线
 * 程数量，每个线程调用await方法告CyclicBarrier我已经到达了屏障，然后当前线程被阻塞。
 *
 * @author xiaohe
 * @time 2020.06.08 14:20
 */
public class CyclicBarrierDemo extends Thread {

    private static Random random = new Random(System.currentTimeMillis());

    private final CyclicBarrier cyclicBarrier;

    public CyclicBarrierDemo(String name, CyclicBarrier cyclicBarrier) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        try {
            int sleepS = random.nextInt(5);
            outTime(name + "执行业务预计耗时" + sleepS + "秒");
            Thread.sleep(sleepS * 1000);

            outTime(name + "执行完毕");
            cyclicBarrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            outTime(name + "-执行失败----");
        }
    }

    private static void outTime(String msg) {
        System.out.println(String.format("%s-%s", LocalTime.now().toString(), msg));
    }

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            // 这个方法里面，可以当作所有线程都执行完毕的通知
            // 该方法由最后一个线程执行
            String name = Thread.currentThread().getName();
            outTime(name + ",所有特工到达屏障，准备开始执行秘密任务");
        });

        for (int i = 0; i < 10; i++) {
            new Thread(new CyclicBarrierDemo("线程" + i, cyclicBarrier)).start();
        }

        cyclicBarrier.await();
        outTime("全部到达屏障....");
        outTime("--------------------------");

        // note : 若第2个屏障和第1个屏障之间隔得太近，会导致相互影响的情况出现
        // 注释下面这行休眠代码，可以看到有时<执行完毕>会在<全部到达屏障>之后打印
        Thread.sleep(1000);

        for (int i = 10; i < 20; i++) {
            new Thread(new CyclicBarrierDemo("线程" + i, cyclicBarrier)).start();
        }

        cyclicBarrier.await();
        outTime("全部到达屏障222....");

        System.exit(0);
    }
}
