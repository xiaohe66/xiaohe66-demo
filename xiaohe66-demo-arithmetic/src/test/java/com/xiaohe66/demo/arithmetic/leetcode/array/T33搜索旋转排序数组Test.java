package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T33搜索旋转排序数组Test {

    T33搜索旋转排序数组 demo = new T33搜索旋转排序数组();

    @Test
    public void test1() {

        assertEquals(4, demo.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, demo.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));

        assertEquals(-1, demo.search(new int[]{1}, 0));
        assertEquals(1, demo.search(new int[]{1,2,3,4}, 2));
        assertEquals(-1, demo.search(new int[]{1,2,3,4}, 5));
        assertEquals(3, demo.search(new int[]{1,2,3,4}, 4));
        assertEquals(2, demo.search(new int[]{1,2,3,4}, 3));
        assertEquals(1, demo.search(new int[]{1,2,3,4}, 2));
        assertEquals(0, demo.search(new int[]{1,2,3,4}, 1));


    }
}