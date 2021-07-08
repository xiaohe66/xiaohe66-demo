package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class T930和相同的二元子数组Test {

    private T930和相同的二元子数组 demo = new T930和相同的二元子数组();

    @Test
    public void test1() {


        assertEquals(4, demo.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        assertEquals(15, demo.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));


    }

    @Test
    public void test2() {

        int len = 30001;

        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = i & 1;

        }

        long start = System.currentTimeMillis();
        assertEquals(40004, demo.numSubarraysWithSum(arr, 5000));
        System.out.println(System.currentTimeMillis() - start);

        Arrays.fill(arr, 1);

        start = System.currentTimeMillis();
        assertEquals(25002, demo.numSubarraysWithSum(arr, 5000));
        System.out.println(System.currentTimeMillis() - start);
    }

}