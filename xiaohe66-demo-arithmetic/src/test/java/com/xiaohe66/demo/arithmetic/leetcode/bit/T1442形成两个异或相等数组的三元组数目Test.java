package com.xiaohe66.demo.arithmetic.leetcode.bit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T1442形成两个异或相等数组的三元组数目Test {


    T1442形成两个异或相等数组的三元组数目 demo = new T1442形成两个异或相等数组的三元组数目();

    @Test
    public void test1() {
        assertEquals(1, demo.countTriplets(new int[]{2, 2}));

        assertEquals(4, demo.countTriplets(new int[]{2, 3, 1, 6, 7}));
        assertEquals(10, demo.countTriplets(new int[]{1, 1, 1, 1, 1}));
        assertEquals(0, demo.countTriplets(new int[]{2, 3}));
        assertEquals(3, demo.countTriplets(new int[]{1, 3, 5, 7, 9}));
        assertEquals(8, demo.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));


    }
}