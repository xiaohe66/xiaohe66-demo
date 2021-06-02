package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *  
 * <p>
 * 提示：
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 * <p>
 * 通过次数31,452提交次数42,764
 *
 * @author xiaohe
 * @time 2021.04.25 09:45
 */
public class T897递增顺序搜索树 {


    private TreeNode last;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了76.92%的用户
     */
    public TreeNode increasingBST(TreeNode root) {
        last = new TreeNode();
        TreeNode ret = last;

        helper(root);

        return ret.right;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        last.right = root;
        root.left = null;
        last = root;

        helper(root.right);
    }


    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了10.35%的用户
     */
    public TreeNode increasingBST2(TreeNode root) {
        if (root == null) {
            return null;
        }
        last = root;
        return helper2(root);
    }

    private TreeNode helper2(TreeNode root) {
        TreeNode ret;

        if (root.left != null) {
            ret = helper2(root.left);
            last.right = root;
            root.left = null;
        } else {
            ret = root;
        }

        if (root.right != null) {
            last = root.right;
            root.right = helper2(root.right);
        } else {
            last = root;
        }
        return ret;
    }

}
