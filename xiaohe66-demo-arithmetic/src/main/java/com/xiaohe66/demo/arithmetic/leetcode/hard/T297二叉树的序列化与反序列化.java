package com.xiaohe66.demo.arithmetic.leetcode.hard;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * 通过次数88,080提交次数160,009
 *
 * @author xiaohe
 * @time 2021.06.30 09:54
 * @see T剑指Offer37序列化二叉树
 */
public class T297二叉树的序列化与反序列化 {


    /**
     * note : 并不需要按力扣的序列化格式来。可以自定义格式。（我最开始理解错了，算了）
     * <p>
     * T297二叉树的序列化与反序列化:
     * 执行用时：17 ms, 在所有 Java 提交中击败了68.14%的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了76.95%的用户
     * <p>
     * T剑指Offer37序列化二叉树:
     * 执行用时：13 ms, 在所有 Java 提交中击败了89.48%的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了73.34%的用户
     */
    public String serialize(TreeNode root) {

        if (root == null) {
            return "[]";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder ret = new StringBuilder();

        int beforeNullQty = 0;
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                beforeNullQty++;
                continue;
            }

            for (int i = 0; i < beforeNullQty; i++) {
                ret.append(",null");
            }

            beforeNullQty = 0;

            ret.append(',');
            ret.append(node.val);

            queue.add(node.left);
            queue.add(node.right);
        }

        ret.setCharAt(0, '[');
        ret.append(']');

        return ret.toString();
    }

    public TreeNode deserialize(String data) {

        if ("[]".equals(data)) {
            return null;
        }


        String[] split = data.split(",");

        int n = split.length - 1;

        split[0] = split[0].replace("[", "");
        split[n] = split[n].replace("]", "");


        TreeNode root = new TreeNode(Integer.parseInt(split[0]));

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int len = n - n % 2;

        int i = 1;
        while (i <= len) {

            TreeNode node = queue.poll();

            if (!"null".equals(split[i])) {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.left);
            }
            i++;

            if (!"null".equals(split[i])) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.right);
            }
            i++;
        }

        // i > len, 单数： len = n - 1, 双 len = n
        // 单 : i == n，双 i > n
        if (i == n) {
            queue.getFirst().left = new TreeNode(Integer.parseInt(split[n]));
        }

        return root;
    }
}
