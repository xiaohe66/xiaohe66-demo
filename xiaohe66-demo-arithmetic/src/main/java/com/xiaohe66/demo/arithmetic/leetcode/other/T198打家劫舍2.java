package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *  
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * <p>
 * 通过次数100,175提交次数238,124
 *
 * @author xiaohe
 * @time 2021.04.15 14:38
 */
public class T198打家劫舍2 {

    /**
     * 动态规划
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了48.49%的用户
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int first1 = nums[0];
        int second1 = Math.max(nums[0], nums[1]);

        int first2 = 0;
        int second2 = nums[1];

        int tmp;

        for (int i = 2; i < nums.length - 1; i++) {
            tmp = second1;
            second1 = Math.max(first1 + nums[i], second1);
            first1 = tmp;

            tmp = second2;
            second2 = Math.max(first2 + nums[i], second2);
            first2 = tmp;
        }

        second2 = Math.max(first2 + nums[nums.length - 1], second2);

        return second1 > second2 ? second1 : second2;

    }

}
