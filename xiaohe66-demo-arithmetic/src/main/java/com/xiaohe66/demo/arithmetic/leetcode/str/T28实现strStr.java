package com.xiaohe66.demo.arithmetic.leetcode.str;

/**
 * 实现 strStr() 函数。
 *
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * <p>
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * <p>
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * <p>
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * <p>
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * <p>
 * 通过次数338,504提交次数847,128
 *
 * @author xiaohe
 * @time 2021.04.20 09:51
 */
public class T28实现strStr {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了39.16%的用户
     * 内存消耗：37.1 MB, 在所有 Java 提交中击败了67.02%的用户
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int n = haystack.length() - needle.length();
        for (int i = 0; i <= n; i++) {

            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

}
