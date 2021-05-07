package com.xiaohe66.demo.arithmetic.leetcode.bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class T1486数组异或操作Test {

    T1486数组异或操作 demo = new T1486数组异或操作();

    @Test
    public void test1() {

        assertEquals(8,demo.xorOperation(5,0));
        assertEquals(8,demo.xorOperation(4,3));
        assertEquals(7,demo.xorOperation(1,7));
        assertEquals(2,demo.xorOperation(10,5));

    }
}