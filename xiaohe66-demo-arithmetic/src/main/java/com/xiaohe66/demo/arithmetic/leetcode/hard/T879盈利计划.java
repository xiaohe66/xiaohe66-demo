package com.xiaohe66.demo.arithmetic.leetcode.hard;

/**
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * <p>
 * 示例 1：
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * <p>
 * 示例 2：
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 * <p>
 * 提示：
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 * <p>
 * 通过次数8,829提交次数17,278
 *
 * @author xiaohe
 * @time 2021.06.09 09:46
 */
public class T879盈利计划 {

    /*
     * 题意解读：
     * 从 profit中选取若干个数量不超过n的数，使其和不小于 minProfit
     */

    /**
     * 在 profitableSchemes2 的基础上，改变了 j和k的位置
     * <p>
     * 执行用时：56 ms, 在所有 Java 提交中击败了57.42%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了65.31%的用户
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        int[][] dp = new int[n + 1][minProfit + 1];
        for (int k = 0; k <= n; k++) {
            dp[k][0] = 1;
        }

        for (int i = 0; i < profit.length; i++) {
            for (int k = n; k >= group[i]; k--) {
                for (int j = minProfit; j >= 0; j--) {

                    int j1 = j <= profit[i] ? 0 : j - profit[i];
                    dp[k][j] = (dp[k][j] + dp[k - group[i]][j1]) % 1000000007;

                }
            }
        }

        return dp[n][minProfit];
    }

    /**
     * 动态规划：
     * 从 profit中选取若干个数量不超过n的数，使其结果不小于 minProfit
     * 设dp[i][j][k]，表示从前i个profit中选取的和不小于j，且人数不超过k的方案数
     * 当 i=0 时，dp[0][0][k] = 1，dp[0][j][k] = 0(j>0)
     * 对于每一个profit[i],都有选和不选
     * group[i] > k,不可选，人数超过了,此时 dp[i][j][k] = dp[i-1][j][k]
     * group[i]<= k,可选或不选。
     * 不选：dp[i][j][k] = dp[i-1][j][k]
     * 选：dp[i][j][k] = dp[i-1][j-profit[i]][k-group[i]]
     * 因此 dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-profit[i]][k-group[i]]
     *
     * <p>
     * 执行用时：29 ms, 在所有 Java 提交中击败了91.63%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了56.46%的用户
     */
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {

        int[][] dp = new int[minProfit + 1][n + 1];
        for (int k = 0; k <= n; k++) {
            dp[0][k] = 1;
        }

        for (int i = 0; i < profit.length; i++) {
            for (int j = minProfit; j >= 0; j--) {
                for (int k = n; k >= group[i]; k--) {

                    int j1 = j <= profit[i] ? 0 : j - profit[i];
                    dp[j][k] = (dp[j][k] + dp[j1][k - group[i]]) % 1000000007;

                }
            }
        }

        return dp[minProfit][n];
    }
}
