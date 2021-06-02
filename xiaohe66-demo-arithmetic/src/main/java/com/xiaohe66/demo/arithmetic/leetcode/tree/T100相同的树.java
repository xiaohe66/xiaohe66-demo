package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>示例 1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * <p>示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 *
 * @author xiaohe
 * @time 2020.08.10 11:50
 */
public class T100相同的树 {

    public boolean isSameTree(TreeNode node1, TreeNode node2) {

        if(node1 == null){
            return node2 == null;
        }

        if(node2 == null || node1.getVal() != node2.getVal()){
            return false;
        }

        return isSameTree(node1.getLeft(), node2.getLeft()) &&
                isSameTree(node1.getRight(), node2.getRight());
    }


}
