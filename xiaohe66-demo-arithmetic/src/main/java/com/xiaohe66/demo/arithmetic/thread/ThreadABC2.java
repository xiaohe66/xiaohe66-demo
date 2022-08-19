package com.xiaohe66.demo.arithmetic.thread;

/**
 *
 * 创建3个线程，一个打印A，一个打印B，一个打印C，使他们交替打印 ABCABCABCABC
 *
 * 设计思路：
 * 1. 设计一个锁类 Lock.class 里面有一个名称字段，有来标识当前应该由哪个线程打印
 * 2. 设计一个线程，需要传入 线程名，下一个线程名，公共锁等数据
 * 3. 在线程 run()中 使用while 判断，若 lock中的线程名不是当前线程名，则进入等待，直到 Lock 中记录的是自己的名称
 * 4. 打印 当前线程名后，修改 lock 中的记录为下一个线程名
 * 5. 最后还要唤醒其它线程，以免循环结束后其它线程未被唤醒的情况
 *
 * 好处：
 * 1.程序的适应性更高，如果需要打印更多字母，只需要 new 更多线程即可
 *
 * @author xiaohe
 * @date 2019.05.08 13:37
 */
public class ThreadABC2 extends Thread{

    private final String nextName;
    private final Lock lock;

    private ThreadABC2(String name, String nextName, Lock lock) {
        super(name);
        this.nextName = nextName;
        this.lock = lock;
    }

    @Override
    public void run() {
        int time = 6;
        for (int i = 0; i < time; i++) {
            synchronized (lock){
                // 如果锁不应该由自己获取，则释放锁，自己进入等待
                while(!lock.name.equals(getName())){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(getName());

                //更改锁的持有者为下一个
                lock.name = nextName;

                // 唤醒其它正在等待的线程
                lock.notifyAll();
            }
        }
    }

    static class Lock{
        String name;

        Lock(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        String[] arr = {"A","B","C","D"};

        Lock lock = new Lock(arr[0]);

        for (int i = 0; i < arr.length; i++) {

            String nextName = i + 1 == arr.length ? arr[0] : arr[i+1];

            new ThreadABC2(arr[i],nextName,lock).start();
        }

    }
}
