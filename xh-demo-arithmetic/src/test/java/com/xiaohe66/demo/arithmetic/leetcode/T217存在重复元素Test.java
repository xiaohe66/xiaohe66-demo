package com.xiaohe66.demo.arithmetic.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T217存在重复元素Test {

    T217存在重复元素 demo = new T217存在重复元素();


    @Test
    public void test2() {

        int[] numbs1 = {2, 31, 15, 27, 39, 151, 12, 67, 14, 12};
        assertTrue(demo.containsDuplicate(numbs1));

        numbs1 = new int[]{2, 31, 15, 27, 39, 151, 12, 67, 14, 13};
        assertFalse(demo.containsDuplicate(numbs1));

        numbs1 = new int[]{2, 31,};
        assertFalse(demo.containsDuplicate(numbs1));

        numbs1 = new int[]{2, 31, 15, 27, 39, 12, 67, 151};
        assertFalse(demo.containsDuplicate(numbs1));


    }
}