package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * <p>
 * 通过次数366,945提交次数515,698
 *
 * @author xiaohe
 * @time 2021.04.01 15:44
 */
public class T136只出现一次的数字 {

    /**
     * 异或：
     * 0 ^ 0 = 0
     * 0 ^ 1 = 1
     * 1 ^ 1 = 0
     *
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了27.15%的用户
     */
    public int singleNumber(int[] nums) {

        int ret = 0;
        for (int num : nums) {
            ret = ret ^ num;
        }
        return ret;
    }

    /**
     * 思路：找到相同的数字时，交换位置，把所有相同的数字放在前面。当遍历到最后一位还没有找到相同的数字时，便是只出现1次的数。
     *
     * <p>
     * 执行用时：135 ms, 在所有 Java 提交中击败了5.00%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了92.56%的用户
     */
    public int singleNumber2(int[] nums) {

        int i = 0;
        int j = i + 1;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {

                int tmp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = tmp;

                i += 2;
                j = i + 1;
            } else {
                j++;
            }
        }
        return nums[i];
    }
}
