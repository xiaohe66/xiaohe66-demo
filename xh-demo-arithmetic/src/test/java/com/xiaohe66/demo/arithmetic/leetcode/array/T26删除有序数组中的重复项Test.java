package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T26删除有序数组中的重复项Test {

    T26删除有序数组中的重复项 demo = new T26删除有序数组中的重复项();

    @Test
    public void test() {

        test(new int[]{1,1,1,1,1}, new int[]{1}, 1);
        test(new int[]{1}, new int[]{1}, 1);
        test(new int[]{}, new int[]{}, 0);

        test(new int[]{1, 1, 2}, new int[]{1, 2}, 2);
        test(new int[]{0,0,1,1,1,2,2,3,3,4}, new int[]{0,1,2,3,4}, 5);

    }

    private void test(int[] nums, int[] correctNums, int correctRet) {
        int ret = demo.removeDuplicates(nums);
        assertEquals(correctRet, ret);
        for (int i = 0; i < correctNums.length; i++) {
            assertEquals(correctNums[i], nums[i]);
        }
    }
}