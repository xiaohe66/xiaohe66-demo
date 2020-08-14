package com.xiaohe66.demo.arithmetic.leetcode;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 3.注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * @author xiaohe
 * @time 2020.08.14 10:04
 */
public class T20有效的括号 {

    /**
     * 思路 :
     *
     * <p>
     * 使用栈的数据结构
     * 当遇到左括号时，入栈。
     * 当遇到右括号时，出栈并判断栈顶的值是不是该右括号的对应左括号。
     */
    boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        // 若长度不为双数，则至少会有一个无法构成括号对
        if (str.length() % 2 == 1) {
            return false;
        }

        // 栈的长度，取字符串的一半即可，因为当入栈的数量超过字符串长度的一半时，表示存在不能构成括号对的值，直接返回即可
        int strL = str.length();
        char[] stack = new char[strL / 2];
        int stackIndex = 0;

        for (int i = 0; i < strL; i++) {
            char c = str.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    if (stackIndex >= stack.length) {
                        return false;
                    }
                    stack[stackIndex++] = c;
                    break;
                case ')':
                    if (--stackIndex < 0 || stack[stackIndex] != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (--stackIndex < 0 || stack[stackIndex] != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (--stackIndex < 0 || stack[stackIndex] != '{') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        // 当所有括号都成对时，栈中的数据会取完，此时下标会为0.若不为0，则表示栈里还存在数据，即表示存在无法成对的括号。
        return stackIndex == 0;
    }

}
