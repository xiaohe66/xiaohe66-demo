package com.xiaohe66.demo.arithmetic.leetcode.other;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LCP07传递信息Test {


    private LCP07传递信息 demo = new LCP07传递信息();

    @Test
    public void test1() {

        assertEquals(1, demo.numWays(2, LeetCodeUtils.stringToArr2("[[0,1]]"), 1));

        assertEquals(3, demo.numWays(5, LeetCodeUtils.stringToArr2("[[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]"), 3));
        assertEquals(0, demo.numWays(3, LeetCodeUtils.stringToArr2("[[0,2],[2,1]]"), 2));

    }

}