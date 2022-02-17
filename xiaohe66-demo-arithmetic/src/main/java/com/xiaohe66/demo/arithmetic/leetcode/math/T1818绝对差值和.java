package com.xiaohe66.demo.arithmetic.leetcode.math;

import java.util.Arrays;

/**
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * <p>
 * |x| 定义为：
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 *  
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * <p>
 * 示例 2：
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 * <p>
 * 示例 3：
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 *  
 * <p>
 * 提示：
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 * 不是余数最小，而是和最小，再对这个最小的和取余
 *
 * <p>
 * 通过次数9,476提交次数24,055
 *
 * @author xiaohe
 * @time 2021.07.14 10:30
 */
public class T1818绝对差值和 {


    /**
     * 思路：官方题解
     * |nums1[i] - nums2[i]|是结果和中的其中一个元素,若存在一个 num1[j] 可以使最小值变小，那么替换前和替换后的绝对值差为
     * |nums1[i] - nums2[i]| - |nums1[j] - nums2[i]|
     * 上式的结果越大，则答案最小值便越小。当 num1[i] 确定时，左式便确定了。
     * 这时，只需要找到 最接近 nums2[i] 的 nums1[j]即可，对比所有的可能，找到使式子的最大值。
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int[] arr = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(arr);

        int ans = 0;

        for (int i = 0; i < nums1.length; i++) {


        }


        return -1;
    }

    public int binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;

        if (arr[right] < num) {
            return right + 1;
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= num) {

                right = mid;

            } else {
                left = mid + 1;
            }

        }
        return left;
    }

}
