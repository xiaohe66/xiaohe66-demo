package com.xiaohe66.demo.arithmetic.leetcode.bit;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * <p>
 * 示例:
 * 输入: 4, 14, 2
 * 输出: 6
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 *
 * <p>
 * 注意:
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 *
 * <p>
 * 通过次数15,978提交次数28,061
 *
 * @author xiaohe
 * @time 2021.05.28 09:51
 */
public class T477汉明距离总和 {


    /**
     * 官方题解：逐位统计
     * 思路：对于每个num的第i个二进制位，都有0和1二种可能。同时，只有0和1的组合才能得出1的距离。
     * 因此，该i位的汉明距离总和 = count(1) * count(0)
     *
     * <p>
     * 执行用时：5 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了86.15%的用户
     */
    public int totalHammingDistance(int[] nums) {

        int sum = 0;
        for (int i = 0; i < 30; i++) {

            int qty = 0;
            for (int num : nums) {
                qty += (num >> i & 1);
            }
            sum += qty * (nums.length - qty);
        }

        return sum;
    }


    /**
     * 提交结果：超过时间限制
     */
    public int totalHammingDistance2(int[] nums) {

        int sum = 0;
        int tmp;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                tmp = nums[i] ^ nums[j];
                while (tmp != 0) {
                    sum += (tmp & 1);
                    tmp = tmp >> 1;
                }
            }
        }

        return sum;
    }
}
