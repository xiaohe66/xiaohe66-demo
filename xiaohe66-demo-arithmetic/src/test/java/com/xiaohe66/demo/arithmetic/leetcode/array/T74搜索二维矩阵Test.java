package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T74搜索二维矩阵Test {

    private T74搜索二维矩阵 demo = new T74搜索二维矩阵();

    private int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

    @Test
    public void test2() {
        assertTrue( demo.searchMatrix(arr, 1));
        assertTrue( demo.searchMatrix(arr, 3));
        assertTrue( demo.searchMatrix(arr, 5));
        assertTrue( demo.searchMatrix(arr, 7));

        assertTrue( demo.searchMatrix(arr, 10));
        assertTrue( demo.searchMatrix(arr, 11));
        assertTrue( demo.searchMatrix(arr, 16));
        assertTrue( demo.searchMatrix(arr, 20));

        assertTrue( demo.searchMatrix(arr, 23));
        assertTrue( demo.searchMatrix(arr, 30));
        assertTrue( demo.searchMatrix(arr, 34));
        assertTrue( demo.searchMatrix(arr, 60));
    }

    @Test
    public void test3() {

        int[][] arr = {{1}};

        assertTrue(demo.searchMatrix(arr,1));
        assertFalse(demo.searchMatrix(arr,2));
    }

    @Test
    public void test4() {

        int[][] arr = {{1,3,5,7,9,11}};

        assertTrue(demo.searchMatrix(arr,1));
        assertTrue(demo.searchMatrix(arr,3));
        assertTrue(demo.searchMatrix(arr,5));
        assertTrue(demo.searchMatrix(arr,7));
        assertTrue(demo.searchMatrix(arr,9));
        assertTrue(demo.searchMatrix(arr,11));

        assertFalse(demo.searchMatrix(arr,0));
        assertFalse(demo.searchMatrix(arr,2));
        assertFalse(demo.searchMatrix(arr,4));
        assertFalse(demo.searchMatrix(arr,6));
        assertFalse(demo.searchMatrix(arr,8));
        assertFalse(demo.searchMatrix(arr,10));
        assertFalse(demo.searchMatrix(arr,12));
    }

    @Test
    public void test5() {

        int[][] arr = {{1},{3},{5},{7},{9},{11}};

        assertTrue(demo.searchMatrix(arr,1));
        assertTrue(demo.searchMatrix(arr,3));
        assertTrue(demo.searchMatrix(arr,5));
        assertTrue(demo.searchMatrix(arr,7));
        assertTrue(demo.searchMatrix(arr,9));
        assertTrue(demo.searchMatrix(arr,11));

        assertFalse(demo.searchMatrix(arr,0));
        assertFalse(demo.searchMatrix(arr,2));
        assertFalse(demo.searchMatrix(arr,4));
        assertFalse(demo.searchMatrix(arr,6));
        assertFalse(demo.searchMatrix(arr,8));
        assertFalse(demo.searchMatrix(arr,10));
        assertFalse(demo.searchMatrix(arr,12));
    }
}