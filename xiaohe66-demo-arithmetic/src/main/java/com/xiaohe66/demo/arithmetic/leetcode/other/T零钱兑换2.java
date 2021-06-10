package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 * <p>
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * <p>
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 * <p>
 * 注意:
 * 你可以假设：
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 * <p>
 * 通过次数63,856提交次数105,197
 *
 * @author xiaohe
 * @time 2021.06.10 10:13
 */
public class T零钱兑换2 {

    /**
     * 查看官方题解后，发现自己的动态规划是可以优化的。
     * 主要是在通项公式上：
     * 不选：dp[i][j] = dp[i-1][j]
     * 选 ：dp[i][j] = dp[i-1][j-coins[i]]
     * 因此，dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i]]
     * 解释：当 coin <= j <= amount时，如果存在一种硬币组合金额之和等于 j-coin，即可得到一组新的硬币组合。
     * 此时，前面有x种等于 j-coin的组合，那么就有x种包含coin且等于j的组合。这时，再加上不包含j的组合，结果就是至此的组合总数。
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了36.85%的用户
     */
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        return dp[amount];
    }


    /**
     * 动态规划：
     * dp[i][j] 表示前i种面额中，组成金额j的方案数
     * 因此, dp[0][0] = 1, dp[0][j] = 0(j>0)
     * 对每个 coins[i], 有选和不选
     * 若 j < coins[i],则不可选，金额超过了。此时 dp[i][j] = dp[i-1][j]
     * 若 j>= coins[i]，2种：
     * 不选：dp[i][j] = dp[i-1][j]
     * 选 ：dp[i][j] = sum(dp[i-1][j - coins[i] * q]), 0 <= q <= j/coins[i]
     * 结果选择：dp[coins.length][amount]
     *
     * <p>
     * 执行用时：52 ms, 在所有 Java 提交中击败了5.11%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了30.02%的用户
     */
    public int change2(int amount, int[] coins) {

        int[] dp = new int[50001];

        dp[0] = 1;

        for (int coin : coins) {

            for (int j = amount; j >= coin; j--) {

                int q = j / coin;

                int sum = 0;
                for (int k = 0; k <= q; k++) {
                    sum += dp[j - coin * k];
                }

                dp[j] = sum;
            }

        }

        return dp[amount];
    }
}
