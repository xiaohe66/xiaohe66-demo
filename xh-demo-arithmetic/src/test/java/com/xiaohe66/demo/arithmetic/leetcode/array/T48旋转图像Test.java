package com.xiaohe66.demo.arithmetic.leetcode.array;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T48旋转图像Test {

    T48旋转图像 demo = new T48旋转图像();

    @Test
    public void test1() {

        int[][] arr = {{1}};
        demo.rotate(arr);
        LeetCodeUtils.outArr2(arr);
        assertArrayEquals(new int[][]{{1}}, arr);

        arr = new int[][]{{1, 2}, {3, 4}};
        demo.rotate(arr);
        LeetCodeUtils.outArr2(arr);
        assertArrayEquals(new int[][]{{3, 1}, {4, 2}}, arr);

        arr = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        demo.rotate(arr);
        LeetCodeUtils.outArr2(arr);
        assertArrayEquals(new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}}, arr);

    }
}