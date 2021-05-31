package com.xiaohe66.demo.arithmetic.leetcode.math;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T342_4的幂Test {

    T342_4的幂 demo = new T342_4的幂();

    @Test
    public void test() {

        // note : 正数的次幂，结果永远不可能为负数
        assertFalse(demo.isPowerOfFour(-1073741824));
        assertFalse(demo.isPowerOfFour(-2147483646));
        assertFalse(demo.isPowerOfFour(-2147483648));

        assertTrue(demo.isPowerOfFour(16));
        assertFalse(demo.isPowerOfFour(5));

        // note : 1是任何数的次幂  -->  n^0 == 1
        assertTrue(demo.isPowerOfFour(1));
    }

    @Test
    public void test2() {
        // 正数的次幂，结果永远不可能为负数
        System.out.println(Math.pow(4, -1));
        System.out.println(Math.pow(4, 0));
        System.out.println(Math.pow(4, 1));
    }

    @Test
    public void test3() {

        System.out.println(~ -715827883);

    }
}