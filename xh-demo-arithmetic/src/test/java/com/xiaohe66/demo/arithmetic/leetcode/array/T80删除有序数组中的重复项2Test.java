package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T80删除有序数组中的重复项2Test {

    T80删除有序数组中的重复项2 demo = new T80删除有序数组中的重复项2();

    @Test
    public void test1() {

        assertEquals(5, demo.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        assertEquals(7, demo.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));

        assertEquals(0, demo.removeDuplicates(new int[]{}));

    }
}