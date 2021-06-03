package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class T525连续数组Test {

    T525连续数组 demo = new T525连续数组();

    @Test
    public void test1() {

        assertEquals(0, demo.findMaxLength(new int[]{0}));
        assertEquals(0, demo.findMaxLength(new int[]{1}));
        assertEquals(2, demo.findMaxLength(new int[]{1, 0}));
        assertEquals(2, demo.findMaxLength(new int[]{0, 1}));

        assertEquals(0, demo.findMaxLength(new int[]{1, 1}));
        assertEquals(0, demo.findMaxLength(new int[]{0, 0}));

        assertEquals(4, demo.findMaxLength(new int[]{0, 0, 1, 1}));
        assertEquals(4, demo.findMaxLength(new int[]{1, 1, 0, 0}));
        assertEquals(4, demo.findMaxLength(new int[]{1, 0, 1, 0}));
        assertEquals(4, demo.findMaxLength(new int[]{0, 1, 1, 0}));

    }

    @Test
    public void testLongArr1() {

        int len = 100000;
        int[] arr = new int[len];
        assertEquals(0, demo.findMaxLength(arr));
    }

    @Test
    public void testLongArr2() {

        int len = 100000;
        int[] arr = new int[len];
        Arrays.fill(arr, 1);
        assertEquals(0, demo.findMaxLength(arr));
    }
}