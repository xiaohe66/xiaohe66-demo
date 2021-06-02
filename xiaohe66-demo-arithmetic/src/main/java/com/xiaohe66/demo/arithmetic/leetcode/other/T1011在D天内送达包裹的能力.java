package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * <p>
 * 示例 1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 *
 * <p>
 * 示例 2：
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 *
 * <p>
 * 示例 3：
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *  
 * 提示：
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 *
 * <p>
 * 通过次数23,536提交次数39,682
 *
 * @author xiaohe
 * @time 2021.04.26 10:08
 */
public class T1011在D天内送达包裹的能力 {


    /**
     * 查看题解后防写。思路：二分查找
     *
     * 执行用时：12 ms, 在所有 Java 提交中击败了62.51%的用户
     * 内存消耗：41.6 MB, 在所有 Java 提交中击败了85.60%的用户
     */
    public int shipWithinDays(int[] weights, int D) {

        int left = 1;
        // 500 * 50000
        int right = 25000000;

        while (left < right) {

            int mid = (left + right) / 2;
            if (check(weights, mid, D)) {
                right = mid;

            } else {

                left = mid + 1;
            }

        }

        return left;
    }

    private boolean check(int[] weights, int mid, int d) {
        int need = 1;
        int sum = 0;
        for (int weight : weights) {
            if (weight > mid) {
                return false;
            }
            if (sum + weight > mid) {
                need++;
                sum = weight;
            } else {
                sum += weight;
            }
        }

        return need <= d;
    }


    private int ans;
    private int[] sumArr;

    /**
     * 提交结果：超过时间限制
     */
    public int shipWithinDays2(int[] weights, int D) {

        if (weights.length == 1) {
            return weights[0];
        }

        ans = Integer.MAX_VALUE;
        sumArr = new int[weights.length + 1];

        for (int i = 0; i < weights.length; i++) {
            sumArr[i + 1] = weights[i] + sumArr[i];
        }

        for (int j = 1; j <= sumArr.length - D; j++) {
            int min = helper(D, 0, weights[0]);
            if (min != -1 && min < ans) {
                ans = min;
            }
        }

        return ans;
    }

    /**
     * @param d   剩余次数
     * @param i   开始位置, 不包含
     * @param max 前面的最大值'
     * @return 最小的最大值
     */
    private int helper(int d, int i, int max) {
        if (d == 1) {
            return Math.max(sumArr[sumArr.length - 1] - sumArr[i], max);
        }

        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j <= sumArr.length - d; j++) {
            int ans1 = Math.max(sumArr[j] - sumArr[i], max);
            if (ans1 > ans) {
                return -1;
            }
            int ans2 = helper(d - 1, j, ans1);
            if (ans2 == -1) {
                return -1;
            }
            if (ans2 < min) {
                min = ans2;
            }
        }

        return min;
    }

}
