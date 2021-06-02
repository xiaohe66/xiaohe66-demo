package com.xiaohe66.demo.arithmetic.leetcode.math;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class T179最大数Test {


    T179最大数 demo = new T179最大数();

    @Test
    public void test1() {

        assertEquals("0", demo.largestNumber(new int[]{0,0}));

        assertEquals("8645124322562161281", demo.largestNumber(new int[]{1,2,4,8,16,32,64,128,256,512}));

        assertEquals("9876543210", demo.largestNumber(new int[]{1,2,3,4,5,6,7,8,9,0}));

        assertEquals("1113111311", demo.largestNumber(new int[]{111311, 1113}));

        assertEquals("4324324323", demo.largestNumber(new int[]{432, 4324323}));
        assertEquals("4324325432", demo.largestNumber(new int[]{432, 4324325}));

        assertEquals("432432432", demo.largestNumber(new int[]{432, 432432}));

        assertEquals("43243432", demo.largestNumber(new int[]{432, 43243}));

        assertEquals("210", demo.largestNumber(new int[]{10, 2}));
        assertEquals("9534330", demo.largestNumber(new int[]{3, 30, 34, 5, 9}));
        assertEquals("1", demo.largestNumber(new int[]{1}));
        assertEquals("10", demo.largestNumber(new int[]{10}));
    }

    @Test
    public void testMyComparator() {

        T179最大数.MyComparator comparator = new T179最大数.MyComparator();

        assertEquals(-1, comparator.compare(Arrays.asList(1,6),Arrays.asList(1,2,8)));

        assertEquals(-1, comparator.compare(Arrays.asList(1,1,1,3),Arrays.asList(1,1,1,3,1,1)));

        assertEquals(1, comparator.compare(Arrays.asList(1,1,1,3,1,1), Arrays.asList(1,1,1,3)));

        assertEquals(1, comparator.compare(Arrays.asList(4, 3, 2), Arrays.asList(4, 3, 2, 4, 3, 2, 5)));
        assertEquals(-1, comparator.compare(Arrays.asList(4, 3, 2), Arrays.asList(4, 3, 2, 4, 3, 2, 3)));

        assertEquals(0, comparator.compare(Arrays.asList(4, 3, 2), Arrays.asList(4, 3, 2, 4, 3, 2)));
        assertEquals(1, comparator.compare(Arrays.asList(4, 3, 2), Arrays.asList(4, 3, 2, 4, 3)));
        assertEquals(-1, comparator.compare(Arrays.asList(4, 3, 2, 4, 3), Arrays.asList(4, 3, 2)));

        assertEquals(1, comparator.compare(Arrays.asList(4, 3), Arrays.asList(4, 4)));
        assertEquals(-1, comparator.compare(Arrays.asList(4, 4), Arrays.asList(4, 3)));
        assertEquals(0, comparator.compare(Arrays.asList(4, 4), Arrays.asList(4, 4)));


    }
}