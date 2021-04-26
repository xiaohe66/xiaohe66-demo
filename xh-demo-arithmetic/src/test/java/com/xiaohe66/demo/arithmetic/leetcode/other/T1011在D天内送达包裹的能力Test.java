package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class T1011在D天内送达包裹的能力Test {

    T1011在D天内送达包裹的能力 demo = new T1011在D天内送达包裹的能力();

    @Test
    public void test1() {

        assertEquals(10, demo.shipWithinDays(new int[]{9, 9, 9, 9, 9, 10, 9, 9, 9, 9}, 10));
        assertEquals(10, demo.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        assertEquals(10, demo.shipWithinDays(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 10));

        assertEquals(10, demo.shipWithinDays(new int[]{10}, 1));
        assertEquals(12, demo.shipWithinDays(new int[]{10, 2}, 1));
        assertEquals(15, demo.shipWithinDays(new int[]{10, 2, 3}, 1));

        assertEquals(10, demo.shipWithinDays(new int[]{10, 2, 3}, 2));
        assertEquals(11, demo.shipWithinDays(new int[]{10, 2, 3, 6}, 2));

        assertEquals(15, demo.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        assertEquals(6, demo.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        assertEquals(3, demo.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));

    }

    @Test
    public void test2() {

        int[] arr = new int[]{474, 465, 91, 171, 362, 15, 187, 270, 29, 279, 283, 207, 210, 246, 131, 346, 500, 140, 142, 420, 244, 326, 99, 51, 464, 241, 307, 313, 98, 52, 140, 296};
        long time = System.currentTimeMillis();
        assertEquals(614, demo.shipWithinDays(arr, 16));
        long time2 = System.currentTimeMillis();

        // 超时
        assertTrue(time2 - time < 1000);

    }
}