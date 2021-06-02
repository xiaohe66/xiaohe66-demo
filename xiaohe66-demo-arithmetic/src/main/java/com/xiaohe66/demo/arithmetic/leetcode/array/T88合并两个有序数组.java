package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 * 提示：
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * <p>
 * 通过次数335,236提交次数660,322
 *
 * @author xiaohe
 * @time 2021.04.08 10:11
 */
public class T88合并两个有序数组 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了37.99%的用户
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }

        int i1 = m - 1;
        int i2 = n - 1;
        int i = nums1.length - 1;

        while (true) {

            if (i2 < 0) {
                return;
            }
            if (i1 < 0) {
                System.arraycopy(nums2, 0, nums1, 0, i2 + 1);
                return;
            }

            if (nums1[i1] > nums2[i2]) {
                nums1[i] = nums1[i1];
                i1--;
            } else {

                nums1[i] = nums2[i2];
                i2--;
            }
            i--;
        }


    }

}
