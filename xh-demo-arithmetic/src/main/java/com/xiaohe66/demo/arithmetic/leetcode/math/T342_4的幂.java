package com.xiaohe66.demo.arithmetic.leetcode.math;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * <p>
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 *
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 *
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 *  
 * <p>
 * 提示：
 * -231 <= n <= 231 - 1
 *
 * <p>
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * <p>
 * 通过次数54,385提交次数105,583
 *
 * @author xiaohe
 * @time 2021.05.31 10:09
 */
public class T342_4的幂 {


    /**
     * 取余：
     * 4^x
     * ==> (3+1)^x
     * ==> 3^x * 1^x
     * ==> mod(3) = 1
     *
     * <p>
     * 未提交
     */
    public boolean isPowerOfFour(int n) {
        return ((n - 1) & n) == 0 && n % 3 == 1;
    }

    /**
     * 思路：
     * 4的次幂，必然为2的次幂。即2进制中，仅有一个1，而4的次幂中的1必然出现在偶数位上。
     * 构造一个数，使其二进制位上所有奇数位都为0，偶数位上都是1。与4的次幂进行按位与操作，结果必然为0.
     *
     * <p>
     * 未提交
     */
    public boolean isPowerOfFour3(int n) {

        // 0xaaaaaaaa 为在二进制位上，所有偶数位都是1，奇数位都是0的数
        return ((n - 1) & n) == 0 && ((n & 0xaaaaaaaa) == 0);
    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.5 MB, 在所有 Java 提交中击败了47.58%的用户
     */
    public boolean isPowerOfFour2(int n) {

        if (n < 1) {
            return false;
        }
        if (((n - 1) & n) != 0) {
            return false;
        }

        while (n >= 4) {
            n = n >> 2;
        }
        return n == 1;
    }

}
