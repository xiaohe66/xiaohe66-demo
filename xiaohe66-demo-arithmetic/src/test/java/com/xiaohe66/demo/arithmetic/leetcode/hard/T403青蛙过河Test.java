package com.xiaohe66.demo.arithmetic.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T403青蛙过河Test {

    T403青蛙过河 demo = new T403青蛙过河();

    @Test
    public void test1() {

        assertTrue(demo.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        assertFalse(demo.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));

    }
}