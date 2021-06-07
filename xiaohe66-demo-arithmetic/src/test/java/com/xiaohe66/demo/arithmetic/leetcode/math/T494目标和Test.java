package com.xiaohe66.demo.arithmetic.leetcode.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class T494目标和Test {

    private T494目标和 demo = new T494目标和();

    @Test
    public void test1() {

        assertEquals(2,demo.findTargetSumWays(new int[]{1,2,1},0));

        assertEquals(0,demo.findTargetSumWays(new int[]{9},1));
        assertEquals(0,demo.findTargetSumWays(new int[]{9,9,9},1));

        assertEquals(5,demo.findTargetSumWays(new int[]{1,1,1,1,1},3));
        assertEquals(1,demo.findTargetSumWays(new int[]{1},1));

    }
}