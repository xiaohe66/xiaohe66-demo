package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *  
 * <p>
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * <p>
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * <p>
 * 通过次数242,017提交次数528,141
 *
 * @author xiaohe
 * @time 2021.03.30 11:32
 */
public class T189旋转数组 {

    /**
     * 思路：3次旋转
     * 1.旋转整个数组
     * 2.旋转前部分
     * 3.旋转后部分
     *
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了56.87%的用户
     */
    public void rotate(int[] nums, int k) {

        if (nums.length < 2) {
            return;
        }

        k = k % nums.length;

        if (k == 0) {
            return;
        }

        int max = nums.length - 1;
        int mid = max / 2;
        int tmp;
        for (int i = 0; i <= mid; i++) {
            int j = max - i;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        mid = (k - 1) / 2;
        for (int i = 0; i <= mid; i++) {
            int j = k - i - 1;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        mid = (max - k) / 2 + k;
        for (int i = k; i <= mid; i++) {
            int j = max - i + k;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }


    }
}
