package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class T144二叉树的前序遍历Test {

    T144二叉树的前序遍历 demo = new T144二叉树的前序遍历();

    @Test
    public void test1() {


        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        assertEquals(new ArrayList<>(Arrays.asList(1,2,3)),demo.preorderTraversal(root));

        root = new TreeNode(3);

        root.left = new TreeNode(1);

        root.left.left = new TreeNode(2);

        assertEquals(new ArrayList<>(Arrays.asList(3,1,2)),demo.preorderTraversal(root));



    }
}