package com.xiaohe66.demo.arithmetic.leetcode.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T1006笨阶乘Test {

    T1006笨阶乘 demo = new T1006笨阶乘();

    @Test
    public void test1() {

        assertEquals(1, demo.clumsy(1));

        assertEquals(7, demo.clumsy(4));

        // 5 * 4 / 3 + 2 - 1 = 6 + 2 - 1 = 7        (2)
        assertEquals(7, demo.clumsy(5));

        // 6 * 5 / 4 + 3 - 2 * 1 = 7 + 3 - 2 =      (2)
        assertEquals(8, demo.clumsy(6));

        // 7 * 6 / 5 + 4 - 3 * 2 /1 = 8 + 4 - 6 = 6 (-1)
        assertEquals(6, demo.clumsy(7));

        // 8 * 7 / 6 + 5 - 4 * 3 / 2 + 1 = 9 + 5 - 6 + 1 = 9    (1)
        assertEquals(9, demo.clumsy(8));

        // 9 * 8 / 7 + 6 - 5 * 4 / 3 + 2 - 1 = 10 + 6 - 6 - 1 = 11  (2)
        assertEquals(11, demo.clumsy(9));
        assertEquals(12, demo.clumsy(10));

        // 11 * 10 / 9 ... + 4 - 3 * 2 / 1
        assertEquals(10, demo.clumsy(11));

    }
}