package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 *  nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 *
 * <p>
 * 示例 2：
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * 输出：3
 *
 * <p>
 * 示例 3：
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * 输出：2
 *
 * <p>
 * 提示：
 * 1 <= nums1.length <= 500
 * 1 <= nums2.length <= 500
 * 1 <= nums1[i], nums2[i] <= 2000
 *  
 * <p>
 * 通过次数11,334提交次数18,937
 *
 * @author xiaohe
 * @time 2021.05.21 10:19
 */
public class T1035不相交的线 {


    /**
     * 查看官方题解后写的：
     * 有感：虽然自己也想到了动态规划，但是写出来的程序与官方题解的效率差了太多。内功都不够呀！！
     * <p>
     * 执行用时：5 ms, 在所有 Java 提交中击败了97.96%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了69.45%的用户
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 0, next; i < nums1.length; i = next) {
            next = i + 1;
            for (int j = 0; j < nums2.length; j++) {
                dp[next][j + 1] = nums1[i] == nums2[j] ?
                        dp[i][j] + 1 :
                        Math.max(dp[next][j], dp[i][j + 1]);
            }
        }

        return dp[nums1.length][nums2.length];
    }

    private Map<Key, Integer> cache;

    /**
     * 对于每一个j，都有选和不选。
     * 选：min(i)为选中的那个i
     * 不选：min(i)继续上一个i
     *
     * <p>
     * 则：
     * f(i,j) = f(newI,j+1)+1  (newI为与nums[j]相等的那个下标)
     * f(i,j) = f(i,j+1)
     *
     * <p>
     * 剪枝：
     * 对每个 f(i,j)进行缓存
     *
     * <p>
     * 执行用时：23 ms, 在所有 Java 提交中击败了6.11%的用户
     * 内存消耗：41.7 MB, 在所有 Java 提交中击败了5.09%的用户
     */
    public int maxUncrossedLines2(int[] nums1, int[] nums2) {
        cache = new HashMap<>();
        return helper(nums1, nums2, new Key(0, 0));
    }

    private int helper(int[] nums1, int[] nums2, Key key) {

        Integer ret = cache.get(key);
        if (ret != null) {
            return ret;
        }

        int newI = 0;
        for (int k = key.i; k < nums1.length; k++) {
            if (nums1[k] == nums2[key.j]) {
                newI = k + 1;
                break;
            }
        }
        if (key.j == nums2.length - 1) {
            return newI > 0 ? 1 : 0;
        }
        int max = helper(nums1, nums2, new Key(key.i, key.j + 1));

        if (newI > 0) {
            int max2 = helper(nums1, nums2, new Key(newI, key.j + 1)) + 1;
            max = max > max2 ? max : max2;
        }
        cache.put(key, max);
        return max;
    }

    private class Key {

        int i;
        int j;

        private Key(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            Key key = (Key) o;

            if (i != key.i) return false;
            return j == key.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }

}
