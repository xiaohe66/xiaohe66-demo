package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 * <p>
 * 通过次数12,408提交次数25,475
 *
 * @author xiaohe
 * @time 2021.07.08 10:19
 */
public class T930和相同的二元子数组 {


    /**
     * 抄的
     * 思路：
     * 统计每个前缀和出现的次数，对于每个右端点，若存在 一个前缀和 =  sum - goal，则答案 +1。
     * 此时，若存在多个相等的前缀和，则说明这些前缀的下标，都可以作为子数组的左端点
     *
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了98.67%的用户
     * 内存消耗：42.1 MB, 在所有 Java 提交中击败了61.64%的用户
     */
    public int numSubarraysWithSum(int[] nums, int goal) {

        int sum = 0;
        int[] countArr = new int[nums.length + 1];

        int ans = 0;
        for (int num : nums) {

            countArr[sum]++;
            sum += num;
            if (sum >= goal) {
                ans += countArr[sum - goal];
            }
        }

        return ans;
    }

    /**
     * 前缀和+遍历子数组左右端点
     * <p>
     * 未提交，感觉会超时
     */
    public int numSubarraysWithSum2(int[] nums, int goal) {

        int[] sums = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        int ans = 0;
        int n = sums.length - goal;
        for (int i = 0; i < n; i++) {

            for (int j = i + goal; j < sums.length; j++) {

                if (j > i && sums[j] - sums[i] == goal) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
