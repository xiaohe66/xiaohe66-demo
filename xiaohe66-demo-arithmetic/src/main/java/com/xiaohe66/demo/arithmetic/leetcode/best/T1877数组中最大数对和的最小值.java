package com.xiaohe66.demo.arithmetic.leetcode.best;

import java.util.Arrays;

/**
 * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
 * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
 * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
 * nums 中每个元素 恰好 在 一个 数对中，且
 * 最大数对和 的值 最小 。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,5,2,3]
 * 输出：7
 * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,5,4,2,4,6]
 * 输出：8
 * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
 * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
 * <p>
 * 提示：
 * n == nums.length
 * 2 <= n <= 105
 * n 是 偶数 。
 * 1 <= nums[i] <= 105
 * <p>
 * 通过次数17,078提交次数20,425
 *
 * @author xiaohe
 * @time 2021.07.20 14:10
 */
public class T1877数组中最大数对和的最小值 {

    /**
     * 执行用时：59 ms, 在所有 Java 提交中击败了96.68%的用户
     * 内存消耗：53.5 MB, 在所有 Java 提交中击败了92.66%的用户
     */
    public int minPairSum(int[] nums) {

        Arrays.sort(nums);

        int ans = 0;
        int mid = nums.length / 2;
        for (int i = 0; i < mid; i++) {

            ans = Math.max(ans, nums[i] + nums[nums.length - i - 1]);
        }

        return ans;
    }
}
