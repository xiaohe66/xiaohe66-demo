package com.xiaohe66.demo.se.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaohe
 * @since 2022.03.08 14:46
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(10);

        scheduled.schedule(() -> {
            System.out.println("延时执行一次");
        }, 1, TimeUnit.SECONDS);

        // 延时2秒后每1秒执行一次
        scheduled.scheduleAtFixedRate(() -> {
            System.out.println("定时-" + System.currentTimeMillis());
        }, 2, 1, TimeUnit.SECONDS);

        // 延时2秒后执行，每次执行完毕后，再经过指定时间后执行
        scheduled.scheduleWithFixedDelay(() -> {
            try {
                // 故意延时，表示当前任务所需要的执行耗时
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("间歇-" + System.currentTimeMillis());
        }, 2, 1, TimeUnit.SECONDS);
    }
}
