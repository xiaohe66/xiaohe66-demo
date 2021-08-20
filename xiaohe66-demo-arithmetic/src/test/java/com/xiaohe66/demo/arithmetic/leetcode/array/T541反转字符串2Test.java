package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class T541反转字符串2Test {

    private T541反转字符串2 demo = new T541反转字符串2();

    @Test
    public void test1() {

        assertEquals("edcbafghijk",demo.reverseStr("abcdefghijk",5));

        assertEquals("a",demo.reverseStr("a",1));
        assertEquals("a",demo.reverseStr("a",3));
        assertEquals("abcdf",demo.reverseStr("abcdf",1));

        assertEquals("ba",demo.reverseStr("ab",2));
        assertEquals("ba",demo.reverseStr("ab",4));
        assertEquals("edcbafg",demo.reverseStr("abcdefg",5));

        assertEquals("bacdfeg",demo.reverseStr("abcdefg",2));
        assertEquals("bacd",demo.reverseStr("abcd",2));


    }
}