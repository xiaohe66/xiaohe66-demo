package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * <P>例如，二叉树 [1,2,2,3,4,4,3] 是对称的
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *
 * <P>但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *
 * @author xiaohe
 * @time 2020.08.07 10:57
 */
public class T101对称二叉树 {


    public boolean isSymmetric(TreeNode node) {
        if(node == null){
            return true;
        }
        return isSymmetric(node.getLeft(), node.getRight());
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.getVal() != right.getVal()) {
            return false;
        }

        return isSymmetric(left.getLeft(), right.getRight()) &&
                isSymmetric(left.getRight(), right.getLeft());
    }


}
