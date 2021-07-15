package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个正整数数组 arr 。请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
 * arr 中 第一个 元素必须为 1 。
 * 任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
 * 你可以执行以下 2 种操作任意次：
 * 减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
 * 重新排列 arr 中的元素，你可以以任意顺序重新排列。
 * 请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。
 * <p>
 * 示例 1：
 * 输入：arr = [2,2,1,2,1]
 * 输出：2
 * 解释：
 * 我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
 * arr 中最大元素为 2 。
 * <p>
 * 示例 2：
 * 输入：arr = [100,1,1000]
 * 输出：3
 * 解释：
 * 一个可行的方案如下：
 * 1. 重新排列 arr 得到 [1,100,1000] 。
 * 2. 将第二个元素减小为 2 。
 * 3. 将第三个元素减小为 3 。
 * 现在 arr = [1,2,3] ，满足所有条件。
 * arr 中最大元素为 3 。
 * <p>
 * 示例 3：
 * 输入：arr = [1,2,3,4,5]
 * 输出：5
 * 解释：数组已经满足所有条件，最大元素为 5 。
 * <p>
 * 提示：
 * 1 <= arr.length <= 105
 * 1 <= arr[i] <= 109
 * <p>
 * 通过次数9,982提交次数15,877
 *
 * @author xiaohe
 * @time 2021.07.15 10:21
 */
public class T1846减小和重新排列数组后的最大元素 {

    /**
     * 官方题解牛逼
     * <p>
     * 最终的数组结果，一定是有序的。除去重复元素外，元素一定是 1,2,3,4,5……自然数排序的。
     * 只要记录缺少的数的数量，并用大于他的数来填充，则可保证最后的数组是升序递增排序的。
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：54.8 MB, 在所有 Java 提交中击败了97.38%的用户
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        int[] qty = new int[arr.length + 1];
        for (int num : arr) {

            if (num > arr.length) {
                qty[arr.length]++;
            } else {
                qty[num]++;
            }
        }

        int miss = 0;
        for (int i = 1; i < qty.length; i++) {

            if (qty[i] == 0) {
                miss++;

            } else {
                miss -= Math.min(qty[i] - 1, miss);
            }
        }
        return arr.length - miss;
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了99.35%的用户
     * 内存消耗：55.3 MB, 在所有 Java 提交中击败了65.43%的用户
     */
    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {

        Arrays.sort(arr);

        int next = 1;

        for (int num : arr) {

            if (next <= num) {
                next++;
            }
        }

        return next - 1;
    }
}
