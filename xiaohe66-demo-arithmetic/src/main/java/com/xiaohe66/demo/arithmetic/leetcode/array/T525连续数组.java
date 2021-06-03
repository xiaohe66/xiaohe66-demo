package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * <p>
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 *
 * <p>
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * nums[i] 不是 0 就是 1
 *
 * <p>
 * 通过次数18,360提交次数36,763
 *
 * @author xiaohe
 * @time 2021.06.03 10:22
 */
public class T525连续数组 {


    /**
     * 官方题解：
     * 当数组中的所有0 改为1，则原题就变成了：求和为0的最长连续子数组
     *
     * <p>
     * 特性：
     * 当第i位和第j位的前缀和相等时，说明（i-j]子数组中的1和0数量相等
     *
     * <p>
     * 具体做法：
     * 使用Hash表保存每个前缀和首次出现的位置，只需要一个前缀和变量，一个即时更新的结果值。
     *
     * <p>
     * 执行用时：19 ms, 在所有 Java 提交中击败了92.24%的用户
     * 内存消耗：47.7 MB, 在所有 Java 提交中击败了82.91%的用户
     */
    public int findMaxLength(int[] nums) {

        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }

            Integer index = map.get(sum);
            if (index == null) {
                map.put(sum, i);

            } else if (i - index > max) {
                max = i - index;
            }

        }
        return max;
    }

    /**
     * 前缀和 朴素解法
     * <p>
     * 提交结果：未提交
     */
    public int findMaxLength2(int[] nums) {

        int[] sums = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        int max = 0;
        for (int i = 0; i < sums.length - 2; i++) {
            for (int j = i + 2; j < sums.length; j++) {

                if ((sums[j] - sums[i]) * 2 == j - i && j - i > max) {
                    max = j - i;
                }
            }
        }

        return max;
    }

}
