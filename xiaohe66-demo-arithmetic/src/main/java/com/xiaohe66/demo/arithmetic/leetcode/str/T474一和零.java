package com.xiaohe66.demo.arithmetic.leetcode.str;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * <p>
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 *
 * <p>
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 * <p>
 * 提示：
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * <p>
 * 通过次数60,810提交次数101,597
 *
 * @author xiaohe
 * @time 2021.06.07 14:19
 */
public class T474一和零 {


    /**
     * 动态规划：
     * 使用滚动数组进行优化，在仔细研究官方题解后
     * <p>
     * 执行用时：34 ms, 在所有 Java 提交中击败了76.62%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了83.98%的用户
     */
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {

            int qty = getOneQty(str);
            int z = str.length() - qty;

            // 倒序遍历 : dp(i+1)与dp(i)的值有关，若正序遍历，则在i+1之前，就把i的值给覆盖了。而倒序遍历则不会。
            // 当 j < z || k < qty 满足时：赋值是这样的：dp[i][j][k] = dp[i][j][k]，相当于无意义。因此直接在循环的过程中限制即可
            for (int j = m; j >= z; j--) {
                for (int k = n; k >= qty; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - z][k - qty] + 1);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 动态规划：
     * 使用滚动数组进行优化，自己写的
     * <p>
     * 执行用时：42 ms, 在所有 Java 提交中击败了48.43%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了83.19%的用户
     */
    public int findMaxForm3(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[][] dp2 = new int[m + 1][n + 1];

        for (String str : strs) {

            int qty = getOneQty(str);
            int z = str.length() - qty;

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {

                    dp2[j][k] = j < z || k < qty ?
                            dp[j][k] :
                            Math.max(dp[j][k], dp[j - z][k - qty] + 1);
                }
            }
            int[][] tmp = dp;
            dp = dp2;
            dp2 = tmp;
        }

        return dp[m][n];
    }


    /**
     * 动态规划：
     * 首先，统计出每个strs[i]中，1的数量，得到1的数量数组 qty，则第i位0的数量为 strs[i].length() - qty[i]，记为 z
     * <p>
     * 设 dp[i][j][k]，表示在前len位中，不大于j个0且不大于k个1的最大子集
     * <p>
     * 对于每一个 qty[i]，都有
     * 1. 若 j < z 或 k < qty[i]，则不选。此时 dp[i][j][k] = dp[i-1][j][k]
     * 2. 若 j>= z 且 k>= qty[i]，则可选，可不选
     * 不选：dp[i][j][k] = dp[i-1][j][k]
     * 选：dp[i][j][k] = dp[i-1][j-z][k-qty[i]] + 1
     * <p>
     * 执行用时：65 ms, 在所有 Java 提交中击败了32.09%的用户
     * 内存消耗：67.1 MB, 在所有 Java 提交中击败了22.78%的用户
     */
    public int findMaxForm2(String[] strs, int m, int n) {

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {

            int qty = getOneQty(strs[i]);
            int z = strs[i].length() - qty;

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {

                    dp[i + 1][j][k] = j < z || k < qty ?
                            dp[i][j][k] :
                            Math.max(dp[i][j][k], dp[i][j - z][k - qty] + 1);
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private int getOneQty(String str) {
        int qty = 0;
        for (int j = 0; j < str.length(); j++) {
            qty += str.charAt(j) - '0';
        }
        return qty;
    }
}
