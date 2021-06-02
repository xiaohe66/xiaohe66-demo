package com.xiaohe66.demo.arithmetic.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T363矩形区域不超过K的最大数值和Test {

    T363矩形区域不超过K的最大数值和 demo = new T363矩形区域不超过K的最大数值和();

    @Test
    public void test1() {


        assertEquals(1, demo.maxSumSubmatrix(new int[][]{{1}}, 1));
        assertEquals(1, demo.maxSumSubmatrix(new int[][]{{1}}, 2));

        assertEquals(12, demo.maxSumSubmatrix(new int[][]{{1,}, {0}, {2}, {2}, {2}, {2}, {2}, {2}}, 12));
        assertEquals(13, demo.maxSumSubmatrix(new int[][]{{1,}, {0}, {2}, {2}, {2}, {2}, {2}, {2}}, 13));
        assertEquals(13, demo.maxSumSubmatrix(new int[][]{{1,}, {0}, {2}, {2}, {2}, {2}, {2}, {2}}, 14));

        assertEquals(10, demo.maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}, {2, 3, 4}}, 11));

        assertEquals(12, demo.maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}, {2, 3, 4}}, 20));

        assertEquals(2, demo.maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
        assertEquals(3, demo.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3));

    }
}