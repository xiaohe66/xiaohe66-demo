package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 * <p>
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * <p>
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * <p>
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 *
 * <p>
 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 * <p>
 * 提示：
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * <p>
 * 通过次数25,638提交次数40,212
 *
 * @author xiaohe
 * @time 2021.05.26 15:27
 */
public class T1190反转每对括号间的子串 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.96%的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了90.05%的用户
     */
    public String reverseParentheses(String s) {

        int n = s.length();
        Stack<Integer> stack = new Stack<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int begin = stack.pop();
                int mid = (i - begin - 1) / 2;

                for (int j = 1; j <= mid; j++) {
                    char tmp = arr[j + begin];
                    arr[j + begin] = arr[i - j];
                    arr[i - j] = tmp;
                }

            }
        }
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '(' && arr[i] != ')') {
                arr[index] = arr[i];
                index++;
            }
        }

        return new String(arr, 0, index);
    }

}
