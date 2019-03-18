package com.xiaohe66.demo.se.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用 Callable 的方式实现线程
 *
 * @author xiaohe
 * @date 2019.03.13 10:51
 */
public class CallableDemo implements Callable<String> {

    private String name;

    private CallableDemo(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        for(int i=0;i<100;i++){
            System.out.println(name+"在线程中输出第："+i);
        }
        return name;
    }

    public static void main(String[] args) throws Exception {

        CallableDemo callable1 = new CallableDemo("张三");
        CallableDemo callable2 = new CallableDemo("李四");

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> future1 = executorService.submit(callable1);
        Future<String> future2 = executorService.submit(callable2);

        //关闭线程池
        executorService.shutdown();

        // 模拟主线程执行其它任务
        Thread.sleep(1000);

        // 输出两个 callable 线程的返回值，调用 get() 方法会阻塞当前线程
        System.out.println("线程1："+future1.get());
        System.out.println("线程2："+future2.get());

    }
}
