package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 * <p>
 * 示例 1：
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 *
 * <p>
 * 示例 2：
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 * <p>
 * 提示：
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 *
 * <p>
 * 通过次数11,782提交次数36,827
 *
 * @author xiaohe
 * @time 2021.07.07 10:59
 */
public class T1711大餐计数 {


    /**
     * 思路：
     * 2个数的和，最大的可能为数组中最大的那个数的2倍
     * 得出最大值和后，遍历该值内所有的 2次幂，
     * 对于每一个deliciousness[i]，若存在一个数与该值的和为2的幂，则数量便可加上该数的数量
     * <p>
     * 总结：
     * 本来自己也想到了利用与2次幂的差值来做缓存，但无奈不知道怎么求出所有的差值。后来看了力扣算法，豁然开朗。
     * <p>
     * 执行用时：141 ms, 在所有 Java 提交中击败了59.66%的用户
     * 内存消耗：46.9 MB, 在所有 Java 提交中击败了96.95%的用户
     */
    public int countPairs(int[] deliciousness) {

        if (deliciousness.length <= 1) {
            return 0;
        }

        int max = 0;
        for (int num : deliciousness) {
            if (num > max) {
                max = num;
            }
        }

        max *= 2;

        int ans = 0;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : deliciousness) {

            for (int sum = 1; sum <= max; sum <<= 1) {

                int sur = sum - num;

                Integer count = countMap.getOrDefault(sur, 0);

                ans += count;
                if (ans >= 1000000007) {
                    ans -= 1000000007;
                }
            }

            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }

        return ans;

    }

    /**
     * 未提交，感觉上应该会超时
     */
    public int countPairs2(int[] deliciousness) {

        int ans = 0;

        for (int i = 0; i < deliciousness.length - 1; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {

                int sum = deliciousness[i] + deliciousness[j];

                if (((sum - 1) & sum) == 0) {

                    ans = ans == 1000000006 ? 0 : ans + 1;

                }
            }
        }


        return ans;
    }
}
