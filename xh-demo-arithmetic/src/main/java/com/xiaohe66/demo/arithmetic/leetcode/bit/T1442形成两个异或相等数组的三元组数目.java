package com.xiaohe66.demo.arithmetic.leetcode.bit;

/**
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * a 和 b 定义如下：
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 * <p>
 * 示例 1：
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 *
 * <p>
 * 示例 2：
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 *
 * <p>
 * 示例 3：
 * 输入：arr = [2,3]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 *
 * <p>
 * 示例 5：
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 *  
 * <p>
 * 提示：
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 *
 * <p>
 * 通过次数13,269提交次数17,391
 *
 * @author xiaohe
 * @time 2021.05.18 10:19
 */
public class T1442形成两个异或相等数组的三元组数目 {

    /**
     * 思路：
     * 设前缀异或数组为 s(x)，i为arr的其中一个下标。则s(i) = arr[0] ^ arr[1] ^ ... ^ arr[i-2] ^ arr[i-1]（注意，不包含 i）
     * 设 [x,y] 的异或结果为 f(x,y), 则 f(x,y) = s(x) ^ s(y+1)
     * <p>
     * 那么，f(i,j) == f(j+1,k)
     * --> s(i) ^ s(j+1) == s(j+1) ^ s(k+1)
     * --> s(i) == s(k + 1)
     *
     * <p>
     * j为 (i,k]中的一个值，由上面可得，当s(i) == s(k + 1)成立时，f(i,j) == f(j+1,k)也成立。
     *
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了56.60%的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了55.66%的用户
     */
    public int countTriplets(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        // 前缀异或
        int[] cache = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            cache[i + 1] = cache[i] ^ arr[i];
        }

        int ret = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (cache[i] == cache[k + 1]) {
                    ret += k - i;
                }
            }
        }

        return ret;
    }

    /**
     * 执行用时：39 ms, 在所有 Java 提交中击败了16.04%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了88.68%的用户
     */
    public int countTriplets2(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        // 前缀异或
        int[] cache = new int[arr.length + 1];
        cache[1] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cache[i + 1] = cache[i] ^ arr[i];
        }

        int ret = 0;
        for (int i = 0; i < cache.length - 1; i++) {
            for (int j = i + 1; j < cache.length; j++) {
                for (int k = j + 1; k < cache.length; k++) {
                    if ((cache[i] ^ cache[j]) == (cache[j] ^ cache[k])) {
                        ret++;
                    }
                }
            }
        }

        return ret;
    }
}
