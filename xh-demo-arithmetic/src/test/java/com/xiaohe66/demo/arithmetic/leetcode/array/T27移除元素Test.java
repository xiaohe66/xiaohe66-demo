package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T27移除元素Test {

    T27移除元素 demo = new T27移除元素();

    @Test
    public void test1() {

        test(new int[]{}, 3, new int[]{}, 0);
        test(new int[]{1}, 1, new int[]{}, 0);

        test(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}, 2);
        test(new int[]{0,1,2,2,3,0,4,2}, 2, new int[]{0,1,4,0,3}, 5);

    }

    private void test(int[] nums, int val, int[] correctNums, int correctRet) {

        int ret = demo.removeElement(nums, val);
        assertEquals(correctRet, ret);
        for (int i = 0; i < correctNums.length; i++) {
            assertEquals(correctNums[i], nums[i]);
        }
    }
}