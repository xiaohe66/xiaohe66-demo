package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T168Excel表列名称Test {

    private T168Excel表列名称 demo = new T168Excel表列名称();

    @Test
    public void test1() {

        for (int i = 1; i <= 26; i++) {

            // @ = 'A' - 1
            String correct = String.valueOf((char) (i + '@'));
            assertEquals(correct, demo.convertToTitle(i));

        }
    }

    @Test
    public void test2() {

        assertEquals("AA", demo.convertToTitle(27));

        assertEquals("AZ", demo.convertToTitle(52));

        // 675 = 25 * 27
        assertEquals("YY", demo.convertToTitle(675));

        // 676 = 26 * 26
        assertEquals("YZ", demo.convertToTitle(676));

        // 702 = 26 * 27
        assertEquals("ZZ", demo.convertToTitle(702));
        assertEquals("AAA", demo.convertToTitle(703));

        // 729 = 27 * 27
        assertEquals("ABA", demo.convertToTitle(729));

        // 17576 = 26 * 26 * 26
        assertEquals("YYZ", demo.convertToTitle(17576));

        // 18954 = 26 * 27 * 27
        assertEquals("AAZZ", demo.convertToTitle(18954));

        assertEquals("FXSHRXW", demo.convertToTitle(Integer.MAX_VALUE));


    }
}