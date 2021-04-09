package com.xiaohe66.demo.arithmetic.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T781森林中的兔子Test {

    T781森林中的兔子 demo = new T781森林中的兔子();

    @Test
    public void test1() {

        assertEquals(0, demo.numRabbits(new int[]{}));
        assertEquals(1, demo.numRabbits(new int[]{0}));
        assertEquals(2, demo.numRabbits(new int[]{1}));

        assertEquals(12, demo.numRabbits(new int[]{2, 2, 2, 2, 3, 3, 3, 1, 1}));

        assertEquals(5, demo.numRabbits(new int[]{1, 1, 2}));
        assertEquals(11, demo.numRabbits(new int[]{10, 10, 10}));

    }
}