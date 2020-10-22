package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class T763划分字母区间Test {

    T763划分字母区间 demo = new T763划分字母区间();

    @Test
    public void test1() {

        assertEquals(Arrays.asList(9, 7, 8), demo.partitionLabels("ababcbacadefegdehijhklij"));

        // 在提交力扣时，遇到的未通过用例，(第2次题解)
        assertEquals(Arrays.asList(1, 9), demo.partitionLabels("caedbdedda"));

    }
}