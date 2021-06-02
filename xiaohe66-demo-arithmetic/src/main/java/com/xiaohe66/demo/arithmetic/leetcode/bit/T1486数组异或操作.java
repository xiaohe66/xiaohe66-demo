package com.xiaohe66.demo.arithmetic.leetcode.bit;

/**
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * <p>
 * 示例 1：
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 *
 * <p>
 * 示例 2：
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 * <p>
 * 示例 3：
 * 输入：n = 1, start = 7
 * 输出：7
 *
 * <p>
 * 示例 4：
 * 输入：n = 10, start = 5
 * 输出：2
 *
 * <p>
 * 提示：
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 * 通过次数44,214提交次数51,641
 *
 * @author xiaohe
 * @time 2021.05.07 10:28
 */
public class T1486数组异或操作 {

    /**
     * 执行用时：0 ms,在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.2 MB, 在所有 Java 提交中击败了68.88%的用户
     */
    public int xorOperation(int n, int start) {

        int cur = start;
        int ret = cur;
        for (int i = 1; i < n; i++) {
            cur = i * 2 + start;
            ret = ret ^ cur;
        }

        return ret;
    }

}
