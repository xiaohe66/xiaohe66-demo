package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T283移动零Test {

    T283移动零 demo = new T283移动零();

    @Test
    public void test1() {

        int[] arr = {0, 1, 0, 3, 12};
        demo.moveZeroes(arr);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, arr);

        arr = new int[]{0};
        demo.moveZeroes(arr);
        assertArrayEquals(new int[]{0}, arr);

        arr = new int[]{0, 2, 3};
        demo.moveZeroes(arr);
        assertArrayEquals(new int[]{2, 3, 0}, arr);

    }
}