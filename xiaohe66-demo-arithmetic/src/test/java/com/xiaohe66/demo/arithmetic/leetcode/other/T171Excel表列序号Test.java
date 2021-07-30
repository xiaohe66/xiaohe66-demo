package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class T171Excel表列序号Test {

    private T171Excel表列序号 demo = new T171Excel表列序号();

    @Test
    public void test1() {

        assertEquals(1,demo.titleToNumber("A"));
        assertEquals(28,demo.titleToNumber("AB"));
        assertEquals(701,demo.titleToNumber("ZY"));
        assertEquals(2147483647,demo.titleToNumber("FXSHRXW"));

    }

}