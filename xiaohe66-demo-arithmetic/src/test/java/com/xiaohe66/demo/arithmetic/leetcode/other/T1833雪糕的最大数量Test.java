package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T1833雪糕的最大数量Test {

    private T1833雪糕的最大数量 demo = new T1833雪糕的最大数量();

    @Test
    public void test1() {


        assertEquals(4, demo.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        assertEquals(0, demo.maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        assertEquals(6, demo.maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }

    @Test
    public void test2() {

        int len = 10000;

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {

            arr[i] = i % 5 + 1;
        }

        assertEquals(5333, demo.maxIceCream(arr, len));


    }
}