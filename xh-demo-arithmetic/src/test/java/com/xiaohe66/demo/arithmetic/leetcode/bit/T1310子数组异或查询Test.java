package com.xiaohe66.demo.arithmetic.leetcode.bit;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T1310子数组异或查询Test {

    T1310子数组异或查询 demo = new T1310子数组异或查询();


    @Test
    public void test1() {

        assertArrayEquals(new int[]{2, 2}, demo.xorQueries(new int[]{2}, new int[][]{{0, 0}, {0, 0}}));

        assertArrayEquals(new int[]{2, 7, 14, 8}, demo.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}}));
        assertArrayEquals(new int[]{8, 0, 4, 4}, demo.xorQueries(new int[]{4, 8, 2, 10}, new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}}));
    }
}