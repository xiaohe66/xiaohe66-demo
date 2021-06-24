package com.xiaohe66.demo.arithmetic.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LeetCodeUtilsTest {

    @Test
    public void test1() {

        System.out.println(Arrays.deepToString(LeetCodeUtils.stringToArr2("[[1,1],[2,2],[3,3]]")));
        System.out.println(Arrays.deepToString(LeetCodeUtils.stringToArr2("[[1]]")));
        System.out.println(Arrays.deepToString(LeetCodeUtils.stringToArr2("[]")));


    }
}