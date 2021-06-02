package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T66加一Test {

    T66加一 demo = new T66加一();

    @Test
    public void test1() {


        assertArrayEquals(new int[]{1, 2, 4}, demo.plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, demo.plusOne(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1}, demo.plusOne(new int[]{0}));

        assertArrayEquals(new int[]{1, 0}, demo.plusOne(new int[]{9}));
        assertArrayEquals(new int[]{1, 0, 0}, demo.plusOne(new int[]{9, 9}));

        assertArrayEquals(new int[]{9, 0, 0}, demo.plusOne(new int[]{8, 9, 9}));

    }
}