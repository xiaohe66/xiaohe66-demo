package com.xiaohe66.demo.arithmetic.leetcode.best;

/**
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * 示例 1：
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * <p>
 * 示例 2：
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * <p>
 * 示例 3：
 * 输入：stones = [1,2]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 * <p>
 * 通过次数16,503提交次数28,786
 *
 * @author xiaohe
 * @time 2021.06.08 10:14
 */
public class T1049最后一块石头的重量2 {


    /**
     * 动态规划：(自己想的)
     * 每次消除，都会消耗掉2倍的分量。因此，数组的总和sum是单数时，结果最小可能为 1，sum为双数时，结果最小可能为 0。
     * 计算出sum后，我们可以得出中间数 mid = sum/2，那么此时问题转变成：
     * 从数组中选取若干的数，使其和最接近 mid。
     * 设数组dp[i][j]表示前i位中，最接近j的和
     * 当 i=0 时，dp[0][j] = 0。
     * 对于每一个 stones[i]，都可选或不可选。
     * 当 j < stones[i]时，不可选。此时 dp[i][j] = dp[i-1][j]
     * 当 j>= stones[i]时: 取以下两个结果的最大值
     * 不选：dp[i][j] = dp[i-1][j]
     * 选：dp[i][j] = dp[i-1][j-stones[i]] + stones[i]
     * 当遍历结束时，dp[stones.length-1][mid]便是最接近 mid的和
     * 当sum为单数时，需要+1，因此最终返回结果为：(mid - dp[stones.length-1][mid]) * 2 + (sum & 1)
     * <p>
     * 执行用时：3 ms, 在所有 Java 提交中击败了88.86%的用户
     * 内存消耗：35.5 MB, 在所有 Java 提交中击败了95.69%的用户
     */
    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // 中间数，向下取整
        int mid = sum / 2;

        // 滚动数组
        int[] dp = new int[mid + 1];

        for (int stone : stones) {
            for (int j = mid; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        return (mid - dp[mid]) * 2 + (sum & 1);
    }

}
