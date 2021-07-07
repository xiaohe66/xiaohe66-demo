package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T1711大餐计数Test {

    private T1711大餐计数 demo = new T1711大餐计数();

    @Test
    public void test1() {

        assertEquals(4, demo.countPairs(new int[]{1, 3, 5, 7, 9}));
        assertEquals(15, demo.countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));

    }

    @Test
    public void test2() {

        int len = 100000;

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i % 567;
        }

        long start = System.currentTimeMillis();

        System.out.println(demo.countPairs(arr));

        System.out.println(System.currentTimeMillis()-start);
    }
}