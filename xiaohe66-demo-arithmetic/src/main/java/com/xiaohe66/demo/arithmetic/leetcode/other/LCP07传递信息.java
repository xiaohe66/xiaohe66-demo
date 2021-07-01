package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 )
 * 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * <p>
 * 示例 1：
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * 输出：3
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 *
 * <p>
 * 示例 2：
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 * 输出：0
 *
 * <p>
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 *
 * <p>
 * 限制：
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 *
 * <p>
 * 通过次数15,356提交次数21,385
 *
 * @author xiaohe
 * @time 2021.07.01 10:55
 */
public class LCP07传递信息 {

    /**
     * 动态规划
     * <p>
     * 定义：dp[i][j]表示经过i轮走到j的方案数
     * dp[0][j] = {1(j=0),0(j>0)}
     * 对于relation中的每1个元素 arr，其中arr[0]表示起点，arr[1]表示终点
     * 在计算 dp[i][j]时，把能到达 arr[0]的数量加起来，便是到达arr[1]的数量
     * 于是，对于 arr[src,dest]，有
     * dp[i][dest] = sum(dp[i-1][src])
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.7 MB, 在所有 Java 提交中击败了90.15%的用户
     */
    public int numWays(int n, int[][] relation, int k) {

        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;

        for (int i = 0; i < k; i++) {

            for (int[] arr : relation) {

                dp[i + 1][arr[1]] += dp[i][arr[0]];

            }
        }
        return dp[k][n - 1];
    }


    /**
     * 深度优先搜索
     * 执行用时：1 ms, 在所有 Java 提交中击败了56.72%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了83.58%的用户
     */
    public int numWays2(int n, int[][] relation, int k) {


        Map<Integer, List<Integer>> relationMap = new HashMap<>();

        for (int[] arr : relation) {

            List<Integer> list = relationMap.computeIfAbsent(arr[0], key -> new ArrayList<>());
            list.add(arr[1]);
        }


        return dfs(relationMap, new int[n + 1][k + 1], 0, k, n - 1);
    }

    private int dfs(Map<Integer, List<Integer>> relationMap, int[][] dp, int no, int k, int target) {

        if (k == 0) {
            return no == target ? 1 : 0;
        }

        if (dp[no][k] != 0) {
            return dp[no][k] == -1 ? 0 : dp[no][k];
        }


        List<Integer> nextNoList = relationMap.get(no);

        int ret = 0;
        if (nextNoList != null) {
            for (Integer nextNo : nextNoList) {

                ret += dfs(relationMap, dp, nextNo, k - 1, target);
            }

        }

        dp[no][k] = ret == 0 ? -1 : ret;

        return ret;
    }

}
