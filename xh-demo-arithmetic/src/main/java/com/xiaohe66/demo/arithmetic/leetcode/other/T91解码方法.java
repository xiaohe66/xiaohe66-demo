package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * <p>
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * <p>
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 *
 * <p>
 * 示例 4：
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *  
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 * <p>
 * 通过次数100,556提交次数375,942
 *
 * @author xiaohe
 * @time 2021.04.21 09:53
 */
public class T91解码方法 {


    /**
     * 0.f(0) = 0, s[0] == 0
     * 1.f(0) = 1, s[0] != 0
     * 2.一位：f(i) = f(i-1), s[i] != 0
     * 3.二位：f(i) = f(i-2), s[i-1] != 0, s[i-1] * 10 + s[i] <= 26, i>1
     *
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了75.35%的用户
     */
    public int numDecodings(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }

        int first = 1;
        int second = 1;
        int cur = 1;

        for (int i = 1; i < s.length(); i++) {
            // note : 为什么初始化为0，因为当 s[i]为0时，cur记录的是上一个循环的值。
            cur = 0;
            if (s.charAt(i) != '0') {
                cur = second;
            }

            if (s.charAt(i - 1) != '0' && (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
                cur += first;
            }

            first = second;
            second = cur;
        }

        return cur;
    }


    /**
     * 执行用时：18 ms, 在所有 Java 提交中击败了5.93%的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了27.77%的用户
     */
    public int numDecodings2(String s) {
        return helper2(s, new int[s.length()], 0);
    }

    /**
     * 求start位当前有多少种可能
     * <p>
     * 1.当start位的字符是0时，后续均不可能。因此可直接返回0
     * 2.除去1的情况，start只取1位是合法的，这时取得 start+1位的数量即是只取1位时的数量
     * 3.当start位字符是1，或为2且start+1位的字符<=6时，取2位是合法的，这时取出start+2位的数量加到前面的结果中
     * 4.结束条件：
     * 当
     */
    private int helper2(String s, int[] cache, int start) {
        if (s.charAt(start) == '0') {
            return 0;
        }

        if (start + 1 == s.length()) {
            return 1;
        }

        if (cache[start] != 0) {
            return cache[start];
        }

        int ret = helper2(s, cache, start + 1);

        if (s.charAt(start) == '1' ||
                (s.charAt(start) == '2' && (s.charAt(start + 1) - '0') <= 6)) {

            ret += start + 2 == s.length() ?
                    1
                    : helper2(s, cache, start + 2);
        }

        cache[start] = ret;
        return ret;
    }


}
