package com.xiaohe66.demo.arithmetic.leetcode.math;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * <p>
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * <p>
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 *
 * <p>
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 *
 * <p>
 * 示例 4：
 * 输入：c = 2
 * 输出：trues
 *
 * <p>
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 *  
 * <p>
 * 提示：
 * 0 <= c <= 231 - 1
 *
 * <p>
 * 通过次数50,655提交次数137,779
 *
 * @author xiaohe
 * @time 2021.04.28 09:51
 */
public class T633平方数之和 {

    /**
     * 执行用时：5 ms在所有 Java 提交中击败了21.32%的用户
     * 内存消耗：35.3 MB, 在所有 Java 提交中击败了30.22%的用户
     */
    public boolean judgeSquareSum(int c) {
        int min = 0;

        while (true) {
            int surplus = c - min * min;
            int sqrt = (int) Math.sqrt(surplus);
            if (sqrt < min) {
                return false;
            }
            if (sqrt * sqrt == surplus) {
                return true;
            }

            min++;
        }
    }
}
