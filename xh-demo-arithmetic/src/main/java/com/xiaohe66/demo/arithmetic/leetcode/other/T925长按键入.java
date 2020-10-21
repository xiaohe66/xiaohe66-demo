package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * <p>
 * 示例 1：
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 *
 * <p>
 * 示例 2：
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 *
 * <p>
 * 示例 3：
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 *
 * @author xiaohe
 * @time 2020.10.21 14:39
 */
public class T925长按键入 {

    public boolean isLongPressedName(String name, String typed) {

        int i = 0;
        int j = 0;

        while (j < typed.length()) {

            char c2 = typed.charAt(j);

            if (i < name.length() && c2 == name.charAt(i)) {
                i++;
                j++;

            }

            // 当name 匹配完时，与 j-1判断，可以确定是否重复输入
            else if (c2 == typed.charAt(j - 1)) {
                j++;

            } else {

                // 当name中的字符与typed中的不等，且不是重复输入时，直接返回 false
                return false;
            }
        }

        // 前面的while 条件可以确保 typed的所有字符都已判断完了，且不存在可直接中断的情况
        // 此时，返回false的情况只有可能是 name中的字符还没有取完，因此直接判断一下 i 是不是等于 name的长度即可确定
        return i == name.length();
    }

}
