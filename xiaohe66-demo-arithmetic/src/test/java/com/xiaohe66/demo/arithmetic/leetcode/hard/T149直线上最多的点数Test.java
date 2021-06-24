package com.xiaohe66.demo.arithmetic.leetcode.hard;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T149直线上最多的点数Test {

    private T149直线上最多的点数 demo = new T149直线上最多的点数();

    @Test
    public void test1() {

        assertEquals(5, demo.maxPoints(LeetCodeUtils.stringToArr2("[[1,1],[2,2],[3,3],[3,4],[3,5],[3,6],[3,7],[4,3],[4,2],[4,5],[4,8],[4,-3]]")));
        assertEquals(4, demo.maxPoints(LeetCodeUtils.stringToArr2("[[1,1],[-1,-1],[2,2],[-2,-2]]")));

        assertEquals(3, demo.maxPoints(LeetCodeUtils.stringToArr2("[[1,1],[1,2],[1,3]]")));
        assertEquals(4, demo.maxPoints(LeetCodeUtils.stringToArr2("[[1,1],[2,1],[3,1],[4,1]]")));
        assertEquals(1, demo.maxPoints(LeetCodeUtils.stringToArr2("[[1,1]]")));

        assertEquals(3, demo.maxPoints(LeetCodeUtils.stringToArr2("[[1,1],[2,2],[3,3]]")));
        assertEquals(4, demo.maxPoints(LeetCodeUtils.stringToArr2("[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]")));


    }
}