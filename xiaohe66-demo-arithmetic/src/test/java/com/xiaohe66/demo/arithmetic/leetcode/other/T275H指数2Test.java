package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class T275H指数2Test {


    private T275H指数2 demo = new T275H指数2();

    @Test
    public void test1() {


        assertEquals(1, demo.hIndex(new int[]{1, 1, 1, 1, 1, 1}));

        assertEquals(0, demo.hIndex(new int[]{0, 0, 0, 0, 0, 0}));

        assertEquals(4, demo.hIndex(new int[]{7, 8, 9, 10}));

        assertEquals(3, demo.hIndex(new int[]{0, 1, 2, 3, 4, 5, 6}));

        assertEquals(3, demo.hIndex(new int[]{0, 1, 3, 5, 6}));

    }

    @Test
    public void test2() {


        int n = 10000;
        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {

            int next;
            do {
                next = random.nextInt(1001);
            } while (next < 0);

            arr[i] = next;
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        assertEquals(demo.hIndex2(arr),demo.hIndex(arr));

    }

}