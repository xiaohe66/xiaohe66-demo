package com.xiaohe66.demo.arithmetic.leetcode.tree;


import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * <p>
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * <p>
 * 通过次数24,432提交次数45,331
 *
 * @author xiaohe
 * @time 2021.05.17 10:34
 */
public class T993二叉树的堂兄弟节点 {

    TreeNode parent;
    int deep;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了70.22%的用户
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, 1);
        int deep = this.deep;
        TreeNode node = this.parent;

        helper(root, y, 1);

        return this.deep == deep && this.parent != node;
    }

    private void helper(TreeNode node, int num, int deep) {

        if (node.left != null) {
            if (node.left.val == num) {
                this.parent = node;
                this.deep = deep;
                return;
            }
            helper(node.left, num, deep + 1);
        }
        if (node.right != null) {
            if (node.right.val == num) {
                this.parent = node;
                this.deep = deep;
                return;
            }
            helper(node.right, num, deep + 1);
        }
    }
}
