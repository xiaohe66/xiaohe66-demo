package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 *  
 * <p>
 * 示例 1：
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 *
 * <p>
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 *
 * <p>
 * 示例 2：
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 *
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *  
 * <p>
 * 提示：
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 * @author xiaohe
 * @time 2020.10.26 16:37
 */
public class T1365有多少小于当前数字的数字 {

    /**
     * 计数法：
     * 本题中，值的范围是 [0,100]，因此可采用计数法，若值的范围不确定或者非常大，则不适合本方法。
     *
     * <p>
     * 统计每1个数次出现的次数，统计完后，小于 num[i]的数为 count[0]~count[i-1]的总和。
     *
     * <p>
     * 执行用时：3 ms, 在所有 Java 提交中击败了75.28%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了95.82%的用户
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] ret = new int[nums.length];
        int[] count = new int[101];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                ret[i] += count[j];
            }
        }

        return ret;
    }

}
