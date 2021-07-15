package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T1846减小和重新排列数组后的最大元素Test {


    private T1846减小和重新排列数组后的最大元素 demo = new T1846减小和重新排列数组后的最大元素();

    @Test
    public void test1() {

        assertEquals(1, demo.maximumElementAfterDecrementingAndRearranging(new int[]{1}));
        assertEquals(1, demo.maximumElementAfterDecrementingAndRearranging(new int[]{1,1,1}));
        assertEquals(4, demo.maximumElementAfterDecrementingAndRearranging(new int[]{9,9,9,9}));

        assertEquals(2, demo.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
        assertEquals(3, demo.maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
        assertEquals(5, demo.maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}));
    }

}