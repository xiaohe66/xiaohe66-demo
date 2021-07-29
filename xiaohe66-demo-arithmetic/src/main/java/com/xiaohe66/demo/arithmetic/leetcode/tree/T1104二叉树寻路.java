package com.xiaohe66.demo.arithmetic.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 * 示例 1：
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * <p>
 * 示例 2：
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 * <p>
 * 提示：
 * 1 <= label <= 10^6
 * <p>
 * 通过次数12,289提交次数16,459
 *
 * @author xiaohe
 * @time 2021.07.29 10:11
 */
public class T1104二叉树寻路 {

    /**
     * 设二叉树的行数为 n,则第 n 行的最小值为 2^(n-1)，最大值为 2^n-1
     *
     * 看以下二叉树, 得父节点.val = 当前节点.val / 2
     *          1
     *     2          3
     *  4    5    6      7
     * 8 9 10 11 12 13 14 15
     * 因此，先以顺序的二叉树得出顺序，再将路径的值进行转换即可
     *
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了47.14%的用户
     */
    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> ansList = new ArrayList<>();

        int sur = label;

        while (sur != 0) {
            ansList.add(sur);
            sur >>= 1;
        }

        Collections.reverse(ansList);
        int n = ansList.size();
        int s = (n + 1) & 1;

        for (int i = 1; i < n - 1; i++) {

            int line = i + 1;
            if ((line & 1) == s) {

                int min = 1 << (line - 1);
                int max = (1 << line) - 1;

                ansList.set(i, max - ansList.get(i) + min);
            }
        }

        return ansList;
    }

}
