package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class T39组合总和Test {

    T39组合总和 demo = new T39组合总和();

    @Test
    public void test1() {

        Set<List<Integer>> set1 = new HashSet<>(Arrays.asList(
                Arrays.asList(7),
                Arrays.asList(3, 2, 2)
        ));

        List<List<Integer>> ret = demo.combinationSum(new int[]{2, 3, 6, 7}, 7);
        Set<List<Integer>> set2 = new HashSet<>(ret);
        assertEquals(set1, set2);

        set1 = new HashSet<>(Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(3, 3, 2),
                Arrays.asList(5, 3)
        ));
        set2 = new HashSet<>(demo.combinationSum(new int[]{2, 3, 5}, 8));
        assertEquals(set1, set2);

        set1 = new HashSet<>(Arrays.asList(
                Arrays.asList(1)
        ));
        set2 = new HashSet<>(demo.combinationSum(new int[]{1}, 1));
        assertEquals(set1, set2);
    }

    @Test
    public void test2() {

        Set<List<Integer>> set1 = new HashSet<>(Arrays.asList(
                Arrays.asList(1, 1, 1, 1),
                Arrays.asList(2, 1, 1),
                Arrays.asList(2, 2)
        ));
        Set<List<Integer>> set2 = new HashSet<>(demo.combinationSum(new int[]{1, 2}, 4));
        assertEquals(set1, set2);

    }
}