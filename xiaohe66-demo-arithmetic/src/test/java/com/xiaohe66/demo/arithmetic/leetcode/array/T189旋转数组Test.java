package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T189旋转数组Test {

    private T189旋转数组 demo = new T189旋转数组();

    @Test
    public void test0() {

        int[] arr = {1};
        demo.rotate(arr, 1);
        assertArrayEquals(new int[]{1}, arr);

    }

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        demo.rotate(arr, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, arr);
    }

    @Test
    public void test2() {
        int[] arr = {-1, -100, 3, 99};
        demo.rotate(arr, 2);
        assertArrayEquals(new int[]{3, 99, -1, -100}, arr);
    }

    @Test
    public void test3() {
        int[] arr = {-1, -100, 3, 99};
        demo.rotate(arr, 4);
        assertArrayEquals(new int[]{-1, -100, 3, 99}, arr);
    }

    @Test
    public void test4() {
        int[] arr = {-1, -100, 3, 99};
        demo.rotate(arr, 3);
        assertArrayEquals(new int[]{-100, 3, 99, -1}, arr);
    }
}