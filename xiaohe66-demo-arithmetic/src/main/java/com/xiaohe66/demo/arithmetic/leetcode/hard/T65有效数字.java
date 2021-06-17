package com.xiaohe66.demo.arithmetic.leetcode.hard;

/**
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * <p>
 * 小数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * <p>
 * 整数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * <p>
 * 部分有效数字列举如下：
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * <p>
 * 部分无效数字列举如下：
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * <p>
 * 示例 1：
 * 输入：s = "0"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = ".1"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
 * <p>
 * 通过次数30,229提交次数126,233
 *
 * @author xiaohe
 * @time 2021.06.17 10:14
 */
public class T65有效数字 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了63.14%的用户
     */
    public boolean isNumber(String s) {

        boolean e = false;
        boolean bot = false;
        int mark = -1;

        int i = 0;
        int n = s.length() - 1;

        while (i <= n) {

            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                mark = i;
                i++;
            }

            for (; i <= n; i++) {

                c = s.charAt(i);
                if (c == '.') {
                    if (e || bot) {
                        return false;
                    }
                    bot = true;
                    mark += 1;

                } else if (c == 'e' || c == 'E') {
                    // 已存在e，或 e前面没有数字
                    if (e || mark + 1 == i) {
                        return false;
                    }
                    e = true;
                    mark = i;
                    i++;
                    break;

                } else if (c - '0' < 0 || c - '0' > 9) {

                    return false;
                }
            }
        }

        return mark != n;
    }
}