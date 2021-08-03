package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 *
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * <p>
 * 通过次数73,712提交次数190,597
 *
 * @author xiaohe
 * @time 2021.08.03 11:22
 */
public class T581最短无序连续子数组 {

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了60.08%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了25.68%的用户
     */
    public int findUnsortedSubarray(int[] nums) {

        int[] clone = nums.clone();
        Arrays.sort(clone);

        int i = 0;
        int j = nums.length - 1;
        while (i <= j && clone[i] == nums[i]) {
            i++;
        }
        while (i <= j && clone[j] == nums[j]) {
            j--;
        }

        return i > j ? 0 : j - i + 1;
    }


    public int findUnsortedSubarray2(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        while (i < j && nums[i] <= nums[i + 1]) {
            i++;
        }
        while (i < j && nums[j - 1] <= nums[j]) {
            j--;
        }

        // todo : o(n) 的解决方案

        return -1;
    }
}
