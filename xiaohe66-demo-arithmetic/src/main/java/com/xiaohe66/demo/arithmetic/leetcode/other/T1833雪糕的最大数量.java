package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.Arrays;

/**
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * 注意：Tony 可以按任意顺序购买雪糕。
 * <p>
 * 示例 1：
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * <p>
 * 示例 2：
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * <p>
 * 示例 3：
 * 输入：costs = [1,6,3,1,2,5], coins = 20
 * 输出：6
 * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
 *  
 * <p>
 * 提示：
 * costs.length == n
 * 1 <= n <= 105
 * 1 <= costs[i] <= 105
 * 1 <= coins <= 108
 * <p>
 * 通过次数25,324提交次数34,292
 *
 * @author xiaohe
 * @time 2021.07.02 11:41
 */
public class T1833雪糕的最大数量 {


    /**
     * 计数
     * 思路来自官网题解
     * <p>
     * 执行用时：6 ms, 在所有 Java 提交中击败了99.43%的用户
     * 内存消耗：54.2 MB, 在所有 Java 提交中击败了96.29%的用户
     */
    public int maxIceCream(int[] costs, int coins) {

        int[] qtyArr = new int[100001];

        for (int cost : costs) {
            qtyArr[cost]++;
        }

        int qty = 0;
        for (int i = 1; i < qtyArr.length; i++) {

            int sum = i * qtyArr[i];
            if (coins < sum) {

                return qty + coins / i;
            }

            qty += qtyArr[i];
            coins -= sum;
        }

        return qty;
    }


    /**
     * 动态规划
     * 未提交，自评：慢
     */
    public int maxIceCream3(int[] costs, int coins) {

        int[] dp = new int[coins + 1];

        for (int cost : costs) {

            for (int j = coins; j >= cost; j--) {

                dp[j] = Math.max(
                        dp[j - cost] + 1,
                        dp[j]);

            }
        }

        return dp[coins];
    }

    /**
     * 思路：每次都买价钱最少的，当剩下的钱不足购买下一个时，便已买到最多数量
     * <p>
     * 执行用时：40 ms, 在所有 Java 提交中击败了54.61%的用户
     * 内存消耗：54.9 MB, 在所有 Java 提交中击败了65.72%的用户
     */
    public int maxIceCream2(int[] costs, int coins) {

        Arrays.sort(costs);

        int i = 0;
        for (; i < costs.length; i++) {
            if (coins < costs[i]) {
                return i;
            }
            coins -= costs[i];
        }
        return i;
    }
}
