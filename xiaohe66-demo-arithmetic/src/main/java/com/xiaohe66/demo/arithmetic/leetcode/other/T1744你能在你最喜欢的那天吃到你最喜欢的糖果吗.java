package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。
 * 同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 *
 * <p>
 * 你按照如下规则进行一场游戏：
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 *
 * <p>
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。
 * answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；
 * 否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 * 请你返回得到的数组 answer 。
 *
 * <p>
 * 示例 1：
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 *
 * <p>
 * 示例 2：
 * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * 输出：[false,true,true,false,false]
 *
 * <p>
 * 提示：
 * 1 <= candiesCount.length <= 10^5
 * 1 <= candiesCount[i] <= 10^5
 * 1 <= queries.length <= 10^5
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 10^9
 * 1 <= dailyCapi <= 10^9
 *
 * <p>
 * 通过次数12,464提交次数35,817
 *
 * @author xiaohe
 * @time 2021.06.01 13:40
 */
public class T1744你能在你最喜欢的那天吃到你最喜欢的糖果吗 {

    /**
     * 思路：
     * 由 candiesCount[] 可构建一个前缀和数组 sums[]。
     * <p>
     * 假设满足要求总共需要吃x个，那么x需要满足：
     * queries[i][1] + 1 <= x <= queries[i][2] * (queries[i][1]+1)
     * 解释：
     * queries[i][1] + 1 ：从第0天开始吃，因此第j天最少必须吃 j+1 个
     * queries[i][2] * (queries[i][1]+1)：每天都吃最多的数量即为最大值
     *
     * <p>
     * 如何判断，设j = queries[i][0], day = queries[i][1] + 1，则:
     * 1. day * 1 <= sums[j+1]，每天吃1个的情况下，不会超过吃完糖果i的总和。（超过了，说明到指定天数的时候，糖果j已经被吃完了）
     * 2. sums[j] < queries[i][2] * day，XXXXX，气死了，不会写懒得写了
     *
     * <p>
     * 注意点：
     * queries[i][2] * queries[i][1] ==> Integer.Max < 10^9 * 10^9 < Long.Max，因此需要使用 long
     *
     * <p>
     * 执行用时：9 ms, 在所有 Java 提交中击败了71.13%的用户
     * 内存消耗：74.9 MB, 在所有 Java 提交中击败了94.37%的用户
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        long[] sums = new long[candiesCount.length + 1];

        for (int i = 0; i < candiesCount.length; i++) {
            sums[i + 1] = sums[i] + candiesCount[i];
        }

        boolean[] ret = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {

            int j = queries[i][0];
            int day = queries[i][1] + 1;

            ret[i] = day <= sums[j + 1] &&
                    sums[j] < (long) queries[i][2] * day;
        }

        return ret;
    }
}
