package com.xiaohe66.demo.arithmetic.leetcode;

/**
 * @author xiaohe
 * @time 2020.08.21 09:45
 */
public class TreeNode {

    // 设置为 public 权限，与力扣中的保持一致
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        if (val != treeNode.val) return false;
        if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) return false;
        return right != null ? right.equals(treeNode.right) : treeNode.right == null;
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        toStringHelper(this, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private void toStringHelper(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        toStringHelper(node.left, stringBuilder);
        stringBuilder.append(node.val);
        stringBuilder.append(',');
        toStringHelper(node.right, stringBuilder);
    }
}
