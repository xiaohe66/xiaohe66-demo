package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T938二叉搜索树的范围和Test {

    T938二叉搜索树的范围和 demo = new T938二叉搜索树的范围和();

    @Test
    public void test1() {

        TreeNode node;

        node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(7);

        node.right = new TreeNode(15);
        node.right.right = new TreeNode(18);

        assertEquals(32, demo.rangeSumBST(node, 7, 15));
    }

    @Test
    public void test2() {

        TreeNode node;

        node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(1);
        node.left.right = new TreeNode(7);
        node.left.right.left = new TreeNode(6);

        node.right = new TreeNode(15);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(18);

        assertEquals(23, demo.rangeSumBST(node, 6, 10));
    }

    @Test
    public void test3() {

        TreeNode node = new TreeNode(5);
        assertEquals(5, demo.rangeSumBST(node, 3, 10));
    }
}