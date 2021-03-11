package com.xiaohe66.demo.arithmetic.leetcode.str;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T227基本计算器2Test {

    T227基本计算器2 demo = new T227基本计算器2();

    @Test
    public void test1() {

        assertEquals(10, demo.calculate("1+2+3+4"));
        assertEquals(100, demo.calculate("10+20+30+40"));
        assertEquals(100, demo.calculate(" 10+ 20 +30 + 40"));

        assertEquals(0, demo.calculate("0+0"));

        assertEquals(4, demo.calculate("10 - 1- 2-3"));
        assertEquals(40, demo.calculate("100-10- 20-30"));
        assertEquals(40, demo.calculate("100  - 10- 20-30"));

        assertEquals(24, demo.calculate("1*2*3*4"));
        assertEquals(240000, demo.calculate("10*20*30*40"));
        assertEquals(240000, demo.calculate("10 * 20*  30 * 40 "));


        assertEquals(2, demo.calculate("100/5/2/5"));
        assertEquals(2, demo.calculate("100000/50/20/50"));
        assertEquals(2, demo.calculate("100000 /  50 / 20/  50"));



    }
}