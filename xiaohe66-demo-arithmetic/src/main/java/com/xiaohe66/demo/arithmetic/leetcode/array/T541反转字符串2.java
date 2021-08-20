package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 * <p>
 * 通过次数49,750提交次数83,781
 *
 * @author xiaohe
 * @since 2021.08.20 10:05
 */
public class T541反转字符串2 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了93.16%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了60.96%的用户
     */
    public String reverseStr(String s, int k) {

        if (k == 1) {
            return s;
        }

        int n = s.length();
        int start = 0;

        char[] chars = s.toCharArray();

        while (start < n) {

            // end 包含
            int end = Math.min(start + k, n) - 1;

            // 不包含中点
            int mid = (end - start + 1) / 2 - 1;

            for (int i = 0; i <= mid; i++) {

                char c = chars[start + i];
                chars[start + i] = chars[end - i];
                chars[end - i] = c;
            }

            start += 2 * k;
        }

        return new String(chars);
    }

}
