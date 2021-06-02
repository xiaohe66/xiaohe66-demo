package com.xiaohe66.demo.arithmetic.leetcode.array;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class T90子集Test {

    private T90子集 demo = new T90子集();

    @Test
    public void test1() {

        List<List<Integer>> correct = Arrays.asList(
                new ArrayList<>(0),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(1, 3),
                Arrays.asList(1, 2, 3)
        );

        assertTrue(LeetCodeUtils.equalsList(correct, demo.subsets(new int[]{1, 2, 3})));
    }

    @Test
    public void test2() {

        List<List<Integer>> correct = new ArrayList<>();
        correct.add(new ArrayList<>(0));

        assertTrue(LeetCodeUtils.equalsList(correct, demo.subsets(new int[]{})));

        correct.add(Arrays.asList(1));
        assertTrue(LeetCodeUtils.equalsList(correct, demo.subsets(new int[]{1})));
    }
}