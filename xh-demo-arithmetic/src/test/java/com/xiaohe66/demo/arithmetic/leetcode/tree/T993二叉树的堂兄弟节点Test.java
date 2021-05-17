package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T993二叉树的堂兄弟节点Test {

    T993二叉树的堂兄弟节点 demo = new T993二叉树的堂兄弟节点();

    @Test
    public void test1() {

        assertFalse(demo.isCousins(LeetCodeUtils.arrayToTreeNode(new Integer[]{1, 2, 3, 4}), 4, 3));
        assertTrue(demo.isCousins(LeetCodeUtils.arrayToTreeNode(new Integer[]{1, 2, 3, null, 4, null, 5}), 5, 4));
        assertFalse(demo.isCousins(LeetCodeUtils.arrayToTreeNode(new Integer[]{1, 2, 3, null, 4}), 2, 3));


    }
}