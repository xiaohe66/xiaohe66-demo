package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T34在排序数组中查找元素的第一个和最后一个位置Test {


    private T34在排序数组中查找元素的第一个和最后一个位置 demo = new T34在排序数组中查找元素的第一个和最后一个位置();

    @Test
    public void test1() {


        assertArrayEquals(new int[]{0, 6}, demo.searchRange(new int[]{8, 8, 8, 8, 8, 8, 8, 10, 10, 10}, 8));
        assertArrayEquals(new int[]{2, 9}, demo.searchRange(new int[]{6, 6, 8, 8, 8, 8, 8, 8, 8, 8}, 8));
        assertArrayEquals(new int[]{1, 9}, demo.searchRange(new int[]{6, 8, 8, 8, 8, 8, 8, 8, 8, 8}, 8));
        assertArrayEquals(new int[]{1, 8}, demo.searchRange(new int[]{6, 8, 8, 8, 8, 8, 8, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{0, 9}, demo.searchRange(new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, 8));

        assertArrayEquals(new int[]{0, 0}, demo.searchRange(new int[]{1}, 1));
        assertArrayEquals(new int[]{-1, -1}, demo.searchRange(new int[]{1}, 2));
        assertArrayEquals(new int[]{3, 3}, demo.searchRange(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4));

        assertArrayEquals(new int[]{3, 4}, demo.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, demo.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[]{-1, -1}, demo.searchRange(new int[]{}, 0));


    }


}