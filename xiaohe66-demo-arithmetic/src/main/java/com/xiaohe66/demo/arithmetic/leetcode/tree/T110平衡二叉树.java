package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回true
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回false
 *
 * @author xiaohe
 * @time 2020.08.17 10:05
 */
public class T110平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    /**
     * 从底部开始扫描，若有1个节点不是平衡的，则整个树都不是平衡的
     */
    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int h1 = height(node.getLeft());
        if(h1 == -1){
            return -1;
        }
        int h2 = height(node.getRight());
        if(h2 == -1){
            return -1;
        }

        if (h1 > h2) {
            int diff = h1 - h2;

            if (diff > 1) {
                return -1;
            }
            return h1 + 1;
        } else {
            int diff = h2 - h1;

            if (diff > 1) {
                return -1;
            }
            return h2 + 1;
        }
    }

}
