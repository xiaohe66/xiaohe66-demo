package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T872叶子相似的树Test {

    T872叶子相似的树 demo = new T872叶子相似的树();

    @Test
    public void test1() {

        assertTrue(demo.leafSimilar(LeetCodeUtils.arrayToTreeNode(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4}),
                LeetCodeUtils.arrayToTreeNode(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8})));

        assertTrue(demo.leafSimilar(LeetCodeUtils.arrayToTreeNode(new Integer[]{1}),
                LeetCodeUtils.arrayToTreeNode(new Integer[]{1})));

        assertFalse(demo.leafSimilar(LeetCodeUtils.arrayToTreeNode(new Integer[]{1}),
                LeetCodeUtils.arrayToTreeNode(new Integer[]{2})));

        assertTrue(demo.leafSimilar(LeetCodeUtils.arrayToTreeNode(new Integer[]{1, 2}),
                LeetCodeUtils.arrayToTreeNode(new Integer[]{2, 2})));

    }
}