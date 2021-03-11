package com.xiaohe66.demo.arithmetic.leetcode.str;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * <p>
 * 整数除法仅保留整数部分。
 *
 * <p>
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 *
 * <p>
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 *
 * <p>
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * <p>
 * 通过次数46,499提交次数111,364
 *
 * @author xiaohe
 * @time 2021.03.11 14:18
 */
public class T227基本计算器2 {

    /**
     * 1.字符串转数字，由最初的 Integer.parseInt 改为了 *10 的方式，节省了内在
     *
     * 自定规则 ： a + b ? c, 当遇到运算符时，c的值为新取得的值，有以下规则
     * 1.当? 乘除时，b = b ? c
     * 2.当? 是加时，a = a + b
     * 3.当? 是减时，a = a + b，b = -c
     *
     *
     * 执行用时：11 ms, 在所有 Java 提交中击败了82.48%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了69.82%的用户
     */
    public int calculate(String s) {

        int sum = 0;
        int tmp = 0;

        int now = 0;
        char last = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                now = now * 10 + c - '0';

            } else {
                switch (c) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        if (last == '*') {
                            tmp *= now;
                        } else if (last == '/') {
                            tmp /= now;
                        } else if (last == '-') {
                            sum += tmp;
                            tmp = -now;
                        } else {
                            sum += tmp;
                            tmp = now;
                        }
                        last = c;
                        now = 0;
                        break;

                    default:

                }
            }
        }

        if (last == '*') {
            return sum + tmp * now;
        } else if (last == '/') {
            return sum + tmp / now;
        } else if (last == '-') {
            return sum + tmp - now;
        } else {
            return sum + tmp + now;
        }
    }

}
