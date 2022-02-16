package com.xiaohe66.demo.se.concurrent;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * jdk 自带的异步编程示例
 *
 * @author xiaohe
 * @since 2022.02.10 16:03
 */
public class CompletableFutureDemo {

    private static CompletableFuture<Void> doSth(String param) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("do sth. param : " + param);
            return null;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String[] arr = {"1", "2", "3", "4", "5"};

        CompletableFuture<Void> all = CompletableFuture.allOf(Arrays.stream(arr)
                .map(CompletableFutureDemo::doSth)
                .toArray(CompletableFuture[]::new));

        CompletableFuture<Object> future = all.thenApply((a) -> {
            System.out.println("done.");
            return null;
        });

        // get方法会阻塞当前线程,直到子线程完成执行任务。
        future.get();

        // end输入语句会在所有线程都执行完后打印
        System.out.println("end.");
    }
}
