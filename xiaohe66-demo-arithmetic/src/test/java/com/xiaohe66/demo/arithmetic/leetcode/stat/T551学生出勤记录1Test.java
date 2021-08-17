package com.xiaohe66.demo.arithmetic.leetcode.stat;

import org.junit.Test;

import static org.junit.Assert.*;

public class T551学生出勤记录1Test {

    private T551学生出勤记录1 demo = new T551学生出勤记录1();

    @Test
    public void test1() {

        assertFalse(demo.checkRecord("ALPLPLPLPLLPPLPLPLPPLLPPPLLPLPLPA"));
        assertTrue(demo.checkRecord("ALPLPLPLPLLPPLPLPLPPLLPPPLLPLPLP"));
        assertFalse(demo.checkRecord("ALPLPLPLPLLPPLPLPLPPLLPPPLLPLPLLLP"));

        assertTrue(demo.checkRecord("A"));
        assertFalse(demo.checkRecord("AA"));

        assertTrue(demo.checkRecord("PPALLP"));
        assertFalse(demo.checkRecord("PPALLL"));

    }
}