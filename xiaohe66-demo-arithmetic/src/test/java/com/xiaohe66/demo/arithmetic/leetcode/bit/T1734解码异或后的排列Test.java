package com.xiaohe66.demo.arithmetic.leetcode.bit;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T1734解码异或后的排列Test {

    T1734解码异或后的排列 demo = new T1734解码异或后的排列();

    @Test
    public void test1() {

        assertArrayEquals(new int[]{1, 2, 3}, demo.decode(new int[]{3, 1}));
        assertArrayEquals(new int[]{2, 4, 1, 5, 3}, demo.decode(new int[]{6, 5, 4, 6}));

    }
}