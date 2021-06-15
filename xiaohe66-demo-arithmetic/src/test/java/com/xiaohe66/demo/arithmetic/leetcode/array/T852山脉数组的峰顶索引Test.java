package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T852山脉数组的峰顶索引Test {


    private T852山脉数组的峰顶索引 demo = new T852山脉数组的峰顶索引();

    @Test
    public void test1() {

        assertEquals(10, demo.peakIndexInMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));

        assertEquals(1, demo.peakIndexInMountainArray(new int[]{0, 1, 0}));
        assertEquals(1, demo.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        assertEquals(1, demo.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        assertEquals(2, demo.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        assertEquals(2, demo.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }

}