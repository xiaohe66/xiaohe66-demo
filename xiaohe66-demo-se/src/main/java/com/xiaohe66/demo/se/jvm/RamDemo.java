package com.xiaohe66.demo.se.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 内存区域讲解代码
 *
 * @author xiaohe
 * @time 2020.11.03 09:47
 */
public class RamDemo {


    private void test(){

        RamDemo ramDemo = new RamDemo();

        // ...



    }

    public int test2() {
        int a = 1;
        int b = 2;
        return (a + b) * 10;

    }


    // gc root
    public static void main(String[] args) throws InterruptedException {

        // 主线程

        // gc root
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            if(i % 3== 0){

                list.add(new byte[1024*1024]);
                Thread.sleep(100);
            }
        }



    }

}
