package com.xiaohe66.demo.arithmetic.leetcode.bit;

/**
 * @author xiaohe
 * @time 2021.05.11 10:33
 */
public class T1734解码异或后的排列 {

    /**
     * 思路：
     * f(xor_i) = encoded[1]^encoded[3]^encoded[3]^...^encoded[i-1]^encoded[i]
     *
     * f(xor_n) = 1^2^3^4...^n-1^n
     * prem[0] = f(xor_n) - f(xor_i)
     *
     * <p>
     * 执行用时： 3 ms, 在所有 Java 提交中击败了98.67%的用户
     * 内存消耗：59.9 MB, 在所有 Java 提交中击败了46.67%的用户
     */
    public int[] decode(int[] encoded) {

        int n = encoded.length + 1;

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }

        for (int i = 1; i < encoded.length; i += 2) {
            total ^= encoded[i];
        }

        int[] ret = new int[n];
        ret[0] = total;
        for (int i = 0; i < encoded.length; i++) {
            ret[i + 1] = ret[i] ^ encoded[i];
        }

        return ret;
    }
}
