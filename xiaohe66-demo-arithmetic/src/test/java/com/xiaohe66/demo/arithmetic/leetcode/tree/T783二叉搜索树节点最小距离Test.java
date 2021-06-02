package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T783二叉搜索树节点最小距离Test {

    T783二叉搜索树节点最小距离 demo = new T783二叉搜索树节点最小距离();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        assertEquals(1, demo.minDiffInBST(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(0);
        root.right = new TreeNode(48);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);

        assertEquals(1, demo.minDiffInBST(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);

        assertEquals(1, demo.minDiffInBST(root));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(2);

        assertEquals(2, demo.minDiffInBST(root));
    }
    @Test
    public void test5() {
        TreeNode root = new TreeNode(27);

        root.right = new TreeNode(34);

        root.right.right = new TreeNode(58);

        root.right.right.left = new TreeNode(50);

        root.right.right.left.left = new TreeNode(44);

        assertEquals(6, demo.minDiffInBST(root));
    }

    @Test
    public void test6() {
        TreeNode root = new TreeNode(90);

        root.left = new TreeNode(69);

        root.left.left = new TreeNode(49);

        root.left.right = new TreeNode(89);

        root.left.left.right = new TreeNode(52);

        assertEquals(1, demo.minDiffInBST(root));
    }
}