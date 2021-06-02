package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 *
 * @author xiaohe
 * @time 2020.08.21 09:58
 */
public class T111二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return min(root, 0, Integer.MAX_VALUE);
    }

    private int min(TreeNode node, int lastDeep, int minDeep) {

        if (node == null || lastDeep >= minDeep) {
            return minDeep;
        }

        lastDeep++;
        if (node.left == null && node.right == null) {
            return lastDeep;
        }

        if(node.left != null){
            minDeep = min(node.left, lastDeep, minDeep);
        }
        if(node.right != null){
            minDeep = min(node.right, lastDeep, minDeep);
        }
        return minDeep;
    }

}
