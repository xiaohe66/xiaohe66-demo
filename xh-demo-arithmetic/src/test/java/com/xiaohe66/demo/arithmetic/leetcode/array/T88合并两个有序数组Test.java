package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T88合并两个有序数组Test {

    T88合并两个有序数组 demo = new T88合并两个有序数组();


    @Test
    public void test1() {

        int[] nums1;

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        demo.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        nums1 = new int[]{1};
        demo.merge(nums1, 1, new int[]{}, 0);
        assertArrayEquals(new int[]{1}, nums1);

        nums1 = new int[]{1,3,4,5,6};
        demo.merge(nums1, 5, new int[]{}, 0);
        assertArrayEquals(new int[]{1,3,4,5,6}, nums1);

        nums1 = new int[]{1,3,4,5,6,0,0,0};
        demo.merge(nums1, 5, new int[]{2,5,6}, 3);
        assertArrayEquals(new int[]{1,2,3,4,5,5,6,6}, nums1);

        nums1 = new int[]{0,0,0,0,0};
        demo.merge(nums1, 0, new int[]{1,3,4,5,6}, 5);
        assertArrayEquals(new int[]{1,3,4,5,6}, nums1);


    }
}