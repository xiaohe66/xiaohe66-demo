package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * <p>
 * 示例：
 *
 * <p>
 * 输入：
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 *
 * <p>
 * 输出：
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 *
 * @author xiaohe
 * @time 2020.09.16 14:41
 */
public class T226翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {

        invertTree2(root);

        return root;
    }

    /**
     * 广度优先
     */
    private void invertTree1(TreeNode node) {

        if (node != null) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            invertTree1(node.left);
            invertTree1(node.right);
        }
    }

    /**
     * 深度优先
     */
    private void invertTree2(TreeNode node) {

        if (node != null) {

            invertTree2(node.left);
            invertTree2(node.right);

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }


    }
}
