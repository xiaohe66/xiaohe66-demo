package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class 剑指Offer53在排序数组中查找数字Test {

    private 剑指Offer53在排序数组中查找数字 demo = new 剑指Offer53在排序数组中查找数字();

    @Test
    public void test1() {


        assertEquals(7, demo.search(new int[]{8, 8, 8, 8, 8, 8, 8, 10, 10, 10}, 8));
        assertEquals(8, demo.search(new int[]{6, 6, 8, 8, 8, 8, 8, 8, 8, 8}, 8));
        assertEquals(9, demo.search(new int[]{6, 8, 8, 8, 8, 8, 8, 8, 8, 8}, 8));
        assertEquals(8, demo.search(new int[]{6, 8, 8, 8, 8, 8, 8, 8, 8, 10}, 8));
        assertEquals(10, demo.search(new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, 8));

        assertEquals(1, demo.search(new int[]{1}, 1));
        assertEquals(0, demo.search(new int[]{1}, 2));
        assertEquals(1, demo.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4));

        assertEquals(2, demo.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertEquals(0, demo.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        assertEquals(0, demo.search(new int[]{}, 0));
    }
}