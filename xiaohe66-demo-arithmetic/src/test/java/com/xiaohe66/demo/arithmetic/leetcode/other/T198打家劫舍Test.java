package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T198打家劫舍Test {

    T198打家劫舍 demo = new T198打家劫舍();

    @Test
    public void test1() {

        assertEquals(4, demo.rob(new int[]{2, 3, 2}));
        assertEquals(3, demo.rob(new int[]{1, 3, 1}));

        assertEquals(5, demo.rob(new int[]{5, 1}));
        assertEquals(5, demo.rob(new int[]{1, 5}));
        assertEquals(1, demo.rob(new int[]{1}));
        assertEquals(0, demo.rob(new int[]{}));

        assertEquals(28, demo.rob(new int[]{2, 7, 9, 2, 9, 2, 3, 8}));

        assertEquals(4, demo.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, demo.rob(new int[]{2, 7, 9, 3, 1}));

    }
}