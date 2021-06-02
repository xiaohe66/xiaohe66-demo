package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * <p>
 * 通过次数341,698提交次数536,254
 *
 * @author xiaohe
 * @time 2021.04.01 16:33
 */
public class T283移动零 {

    /**
     * 思路：双指针
     *
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了81.17%的用户
     */
    public void moveZeroes(int[] nums) {

        int zoreStart = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[zoreStart] = nums[i];
                zoreStart++;
            }
        }

        for (int i = zoreStart; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
