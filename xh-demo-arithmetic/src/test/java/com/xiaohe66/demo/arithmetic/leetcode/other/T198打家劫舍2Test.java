package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T198打家劫舍2Test {


    T198打家劫舍2 demo = new T198打家劫舍2();


    @Test
    public void test1() {


        assertEquals(15, demo.rob(new int[]{3,5,2,5,3,5}));

        assertEquals(10, demo.rob(new int[]{3,5,2,5,3}));
        assertEquals(5, demo.rob(new int[]{3,2,2,2,3}));

        assertEquals(4, demo.rob(new int[]{4, 3}));
        assertEquals(3, demo.rob(new int[]{2, 3}));
        assertEquals(0, demo.rob(new int[]{}));

        assertEquals(3, demo.rob(new int[]{2, 3, 2}));
        assertEquals(4, demo.rob(new int[]{1, 2, 3, 1}));
        assertEquals(0, demo.rob(new int[]{0}));

    }
}