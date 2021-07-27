package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T671二叉树中第二小的节点Test {

    private T671二叉树中第二小的节点 demo = new T671二叉树中第二小的节点();

    @Test
    public void test1() {

        assertEquals(2147483647, demo.findSecondMinimumValue(LeetCodeUtils.arrayToTreeNode(new Integer[]{2, 2, 2147483647})));

        assertEquals(2, demo.findSecondMinimumValue(LeetCodeUtils.arrayToTreeNode(new Integer[]{1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1})));

        assertEquals(5, demo.findSecondMinimumValue(LeetCodeUtils.arrayToTreeNode(new Integer[]{2, 2, 5, null, null, 5, 7})));
        assertEquals(-1, demo.findSecondMinimumValue(LeetCodeUtils.arrayToTreeNode(new Integer[]{2, 2, 2})));


    }

}