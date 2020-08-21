package com.xiaohe66.demo.arithmetic.leetcode.str;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 示例 1：
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>
 * 示例 2：
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * 提示：
 * 输入的字符串长度不会超过 1000 。
 *
 * @author xiaohe
 * @time 2020.08.19 10:22
 */
public class T647回文子串 {

    /**
     * 方式2：找出所有回文中心，然后往两边扩展
     */
    public int countSubstrings(String s) {

        // todo : impl
        return 0;
    }

    /**
     * 解法1:效率低
     */
    public int countSubstrings2(String s) {
        if (s == null) {
            return 0;
        }

        int count = s.length();
        if (count < 2) {
            return count;
        }

        for (int len = 2; len <= s.length(); len++) {
            int half = len / 2 - 1;
            for (int start = 0, end = start + len - 1; start <= s.length() - len; start++, end++) {

                boolean isSame = true;
                for (int offset = 0; offset <= half; offset++) {
                    char a = s.charAt(start + offset);
                    char b = s.charAt(end - offset);
                    if (a != b) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    count++;
                }
            }
        }

        return count;
    }

}
