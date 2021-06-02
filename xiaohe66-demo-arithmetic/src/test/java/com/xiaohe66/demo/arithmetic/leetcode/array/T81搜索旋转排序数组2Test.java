package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T81搜索旋转排序数组2Test {

    T81搜索旋转排序数组2 demo = new T81搜索旋转排序数组2();

    @Test
    public void test1() {


        assertTrue(demo.search(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1}, 13));

        assertTrue(demo.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 2));
        assertTrue(demo.search(new int[]{4, 4, 4, 4, 4, 4, 4, 3, 4}, 3));
        assertTrue(demo.search(new int[]{4, 4, 4, 4, 4, 4, 4, 3, 4}, 4));

        assertTrue(demo.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        assertFalse(demo.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));


    }
}