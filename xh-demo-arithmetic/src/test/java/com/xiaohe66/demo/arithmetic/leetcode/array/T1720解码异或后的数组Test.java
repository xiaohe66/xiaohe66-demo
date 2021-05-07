package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T1720解码异或后的数组Test {

    T1720解码异或后的数组 demo = new T1720解码异或后的数组();

    @Test
    public void test1() {

        assertArrayEquals(new int[]{1, 0, 2, 1}, demo.decode(new int[]{1, 2, 3}, 1));
        assertArrayEquals(new int[]{4, 2, 0, 7, 4}, demo.decode(new int[]{6, 2, 7, 3}, 4));

    }
}