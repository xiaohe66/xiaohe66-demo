package com.xiaohe66.demo.arithmetic.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 什么是重复元素：若输入里面存在1个字母a，则输出里面只有1个字母a。若输入里面有2个字母a，则输出里面也要有2个字母a。
 *
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * <p>
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * <p>
 * 通过次数110,619提交次数194,307
 *
 * @author xiaohe
 * @time 2021.06.22 10:14
 */
public class T剑指Offer38字符串的排列 {

    private Set<String> set;
    private boolean[] mark;

    /**
     * 执行用时：31 ms, 在所有 Java 提交中击败了37.18%的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了77.30%的用户
     */
    public String[] permutation(String s) {

        set = new HashSet<>();
        mark = new boolean[s.length()];

        char[] arr = new char[s.length()];

        help(s, 0, arr);

        return set.toArray(new String[0]);
    }

    private void help(String s, int index, char[] arr) {

        if (index == arr.length) {
            set.add(new String(arr));
            return;
        }

        for (int i = 0; i < mark.length; i++) {

            if (!mark[i]) {

                arr[index] = s.charAt(i);
                mark[i] = true;
                help(s, index + 1, arr);
                mark[i] = false;
            }

        }

    }
}
