package com.xiaohe66.demo.arithmetic.leetcode.str;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * <p>
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * <p>
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * @author xiaohe
 * @time 2020.08.31 17:17
 */
public class T557反转字符串中的单词3 {

    public String reverseWords(String s) {

        String[] woldArr = s.split(" ");

        int l = s.length();
        char[] arr = new char[l];

        int index = 0;
        for (String s1 : woldArr) {
            for (int j = s1.length() - 1; j >= 0; j--) {
                arr[index++] = s1.charAt(j);
            }
            if (index < l) {
                arr[index++] = ' ';
            }
        }


        return new String(arr);
    }
}
