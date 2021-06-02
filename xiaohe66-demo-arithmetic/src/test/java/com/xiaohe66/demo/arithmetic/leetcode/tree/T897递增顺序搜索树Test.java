package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T897递增顺序搜索树Test {

    T897递增顺序搜索树 demo = new T897递增顺序搜索树();

    @Test
    public void test1() {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(2);
        node.left.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);

        node.right = new TreeNode(6);
        node.right.right = new TreeNode(8);
        node.right.right.left = new TreeNode(7);
        node.right.right.right = new TreeNode(9);

        assertEquals(newRightTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}), demo.increasingBST(node));
    }

    @Test
    public void test2() {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(7);

        assertEquals(newRightTree(new int[]{1, 5, 7}), demo.increasingBST(node));
    }

    @Test
    public void test3() {
        TreeNode node = new TreeNode(5);
        assertEquals(new TreeNode(5), demo.increasingBST(node));
    }

    @Test
    public void test4() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(2);
        node.left.left.left.left = new TreeNode(1);
        assertEquals(newRightTree(new int[]{1, 2, 3, 4, 5}), demo.increasingBST(node));
    }

    @Test
    public void test5() {
        TreeNode node = new TreeNode(5);
        node.right = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.right.right.right = new TreeNode(8);
        node.right.right.right.right = new TreeNode(9);
        assertEquals(newRightTree(new int[]{5, 6, 7, 8, 9}), demo.increasingBST(node));
    }

    @Test
    public void test6() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(1);
        node.left.left.left.left = new TreeNode(0);
        node.left.left.left.right = new TreeNode(2);
        assertEquals(newRightTree(new int[]{0, 1, 2, 3, 4, 5}), demo.increasingBST(node));
    }


    private TreeNode newRightTree(int[] arr) {
        if (arr == null) {
            return null;
        }

        TreeNode ret = new TreeNode();
        TreeNode node = ret;
        for (int val : arr) {
            node.right = new TreeNode(val);
            node = node.right;
        }
        return ret.right;
    }

}