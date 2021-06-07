package com.xiaohe66.demo.arithmetic.leetcode.math;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 * <p>
 * 通过次数94,117提交次数199,948
 *
 * @author xiaohe
 * @time 2021.06.07 09:57
 */
public class T494目标和 {


    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了67.63%的用户
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int dif = sum - target;

        if (dif < 0 || dif % 2 != 0) {
            return 0;
        }

        int neg = dif / 2;


        // 使用滚动数组
        int[] dp = new int[neg + 1];
        int[] dp2 = new int[neg + 1];

        dp[0] = 1;

        for (int num : nums) {
            for (int j = 0; j <= neg; j++) {
                dp2[j] = j < num ?
                        dp[j] :
                        dp[j] + dp[j - num];
            }
            int[] tmp = dp;
            dp = dp2;
            dp2 = tmp;
        }

        return dp[neg];
    }

    /**
     * 动态规划：(看了下官方题解)
     * 数组的和为 sum，设所有给予 - 号的和为  neg，则所有 + 号的和为 sum - neg。则：
     * (sum - neg) - neg = target ==> sum - 2 * neg = target ==> neg = (sum - target) / 2
     * 此时：
     * 若 sum == target，则算式全部都为 + 号才可能存在1种方案。
     * 若 sum < target，则方案数为0。
     * 若 sum - target 为单数，则不满足 neg = (sum - target) / 2，可直接返回。
     *
     * <p>
     * 此时，问题转变成：从数组中选取若干数，使其和等于 neg。
     * 设dp[i][j]为在前i个元素中选取和为j的方案数。故：
     * dp[0][j] = {1(neg = 0),  0(neg > 0)}
     *
     * <p>
     * 对于每一个num，num = nums[i]
     * 若 j < num，则不能选(选了会使和大于neg)，此时 dp[i][j] = dp[i-1][j]
     * 若 j>= num，则可以选，也可以不选。
     * 不选： dp[i][j] = dp[i-1][j]。
     * 选： dp[i][j] = dp[i-1][j - nums[i]], 解释：目标和为 j ,由于选num，因此需要在前面找到和为 j-num的方案数。
     *
     * <p>
     * 执行用时：4 ms, 在所有 Java 提交中击败了78.12%的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了37.94%的用户
     */
    public int findTargetSumWays3(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int dif = sum - target;

        if (dif < 0 || dif % 2 != 0) {
            return 0;
        }

        int neg = dif / 2;
        int[][] dp = new int[nums.length + 1][neg + 1];

        dp[0][0] = 1;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j <= neg; j++) {

                dp[i + 1][j] = j < nums[i] ?
                        dp[i][j] :
                        dp[i][j] + dp[i][j - nums[i]];
            }
        }

        return dp[nums.length][neg];
    }


    HashMap<Integer, Integer>[] cache;

    /**
     * 动态规划：
     * 执行用时：37 ms, 在所有 Java 提交中击败了43.33%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了20.99%的用户
     */
    public int findTargetSumWays2(int[] nums, int target) {

        cache = new HashMap[nums.length];

        return help2(nums, target, 0);
    }

    private int help2(int[] nums, int target, int index) {

        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        if (cache[index] != null) {
            Integer value = cache[index].get(target);
            if (value != null) {
                return value;
            }
        } else {
            cache[index] = new HashMap<>();
        }

        int ret = help2(nums, target + nums[index], index + 1);
        ret += help2(nums, target - nums[index], index + 1);

        cache[index].put(target, ret);

        return ret;
    }
}
