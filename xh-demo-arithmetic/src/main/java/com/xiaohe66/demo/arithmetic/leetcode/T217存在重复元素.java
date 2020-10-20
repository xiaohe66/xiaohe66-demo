package com.xiaohe66.demo.arithmetic.leetcode;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author xiaohe
 * @time 2020.10.19 17:34
 */
public class T217存在重复元素 {


    /**
     * 插入排序 + 二分法查找
     * <p>
     * 特点 ： 省内存、耗时长
     */
    public boolean containsDuplicate(int[] nums) {

        int i = 0;
        int tmp;
        for (; i < nums.length - 1 && i < 7; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
                if (nums[j] < nums[i]) {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }

        for (i = 8; i < nums.length; i++) {

            int ret = find(nums, nums[i], 0, i, i);
            if (ret == -1) {
                return true;
            }

        }

        return false;
    }

    public int find(int[] nums, int num, int start, int end, int endG) {

        int index = (end - start) / 2 + start;

        if (index == start) {

            if (end != endG) {

                if (nums[index] == num) {
                    return -1;
                }

                // 插入排序

                int src;
                int dest;
                if (num > nums[end]) {
                    src = end + 1;
                    dest = end + 2;

                } else if (num < nums[start]) {
                    src = start;
                    dest = end;

                } else {
                    src = end;
                    dest = end + 1;
                }

                int len = endG > dest && endG == nums.length ? endG - start : end - start;

                // 移动数组元素
                System.arraycopy(nums, src, nums, dest, len);
                nums[src] = num;
            }

            return 0;
        }

        if (nums[index] == num) {
            return -1;
        }

        // 二分法查找
        if (nums[index] > num) {
            return find(nums, num, start, index, endG);

        } else {

            return find(nums, num, index, end, endG);
        }

    }

}
