package com.xiaohe66.demo.arithmetic.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T879盈利计划Test {

    private T879盈利计划 demo = new T879盈利计划();

    @Test
    public void test1() {

        assertEquals(2, demo.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
        assertEquals(7, demo.profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
    }
}