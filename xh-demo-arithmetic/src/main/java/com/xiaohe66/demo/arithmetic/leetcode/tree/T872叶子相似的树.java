package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

import java.util.Stack;

/**
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * <p>
 * 示例 1：
 *
 * <p>
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 *
 * <p>
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 *
 * <p>
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 *
 * <p>
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 *
 * <p>
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *  
 * <p>
 * 提示：
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 *
 * <p>
 * 通过次数31,170提交次数48,535
 *
 * @author xiaohe
 * @time 2021.05.10 09:43
 */
public class T872叶子相似的树 {

    /**
     * 执行用时：0 ms , 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了62.96%的用户
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        if (root1 == root2) {
            return true;
        }

        TreeNode node1 = root1;
        TreeNode node2 = root2;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while (node1 != null && node2 != null) {

            int value1;
            while (true) {

                if (node1.left != null) {
                    if (node1.right != null) {
                        stack1.push(node1.right);
                    }
                    node1 = node1.left;
                } else if (node1.right != null) {
                    node1 = node1.right;

                } else {
                    value1 = node1.val;
                    node1 = stack1.isEmpty() ? null : stack1.pop();
                    break;
                }
            }
            while (true) {

                if (node2.left != null) {
                    if (node2.right != null) {
                        stack2.push(node2.right);
                    }
                    node2 = node2.left;
                } else if (node2.right != null) {
                    node2 = node2.right;

                } else {
                    if (value1 != node2.val) {
                        return false;
                    }
                    node2 = stack2.isEmpty() ? null : stack2.pop();
                    break;
                }
            }
        }

        return node1 == node2;
    }
}
