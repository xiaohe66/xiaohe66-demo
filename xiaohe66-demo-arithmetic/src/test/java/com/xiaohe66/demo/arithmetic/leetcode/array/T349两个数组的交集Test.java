package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T349两个数组的交集Test {

    T349两个数组的交集 demo = new T349两个数组的交集();

    @Test
    public void test1() {

        assertArrayEquals(new int[]{2}, demo.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));

        assertArrayEquals(new int[]{4, 9}, demo.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));

        assertArrayEquals(new int[]{}, demo.intersection(new int[]{1}, new int[]{9, 4, 9, 8, 4}));

        assertArrayEquals(new int[]{}, demo.intersection(new int[]{}, new int[]{9, 4, 9, 8, 4}));

        assertArrayEquals(new int[]{1}, demo.intersection(new int[]{1}, new int[]{1}));

        assertArrayEquals(new int[]{}, demo.intersection(new int[]{1}, new int[]{2}));


    }
}