package com.xiaohe66.demo.arithmetic.leetcode.str;

/**
 * 给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
 * 如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
 * <p>
 * 示例 1：
 * 输入：s = "annabelle", k = 2
 * 输出：true
 * 解释：可以用 s 中所有字符构造 2 个回文字符串。
 * 一些可行的构造方案包括："anna" + "elble"，"anbna" + "elle"，"anellena" + "b"
 * <p>
 * 示例 2：
 * 输入：s = "leetcode", k = 3
 * 输出：false
 * 解释：无法用 s 中所有字符构造 3 个回文串。
 * <p>
 * 示例 3：
 * 输入：s = "true", k = 4
 * 输出：true
 * 解释：唯一可行的方案是让 s 中每个字符单独构成一个字符串。
 * <p>
 * 示例 4：
 * 输入：s = "yzyzyzyzyzyzyzy", k = 2
 * 输出：true
 * 解释：你只需要将所有的 z 放在一个字符串中，所有的 y 放在另一个字符串中。那么两个字符串都是回文串。
 * <p>
 * 示例 5：
 * 输入：s = "cr", k = 7
 * 输出：false
 * 解释：我们没有足够的字符去构造 7 个回文串。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s 中所有字符都是小写英文字母。
 * 1 <= k <= 10^5
 *
 * @author xiaohe
 * @time 2020.08.17 13:41
 */
public class T1400构造K个回文字符串 {

    public boolean canConstruct(String str, int k) {

        int strL = str.length();

        // 若字符串长度相等，则每个字符构成1个回文串，可以直接返回
        if (k == strL) {
            return true;
        }

        // 若需要的回文串数量大于总字符数量，则不可能
        if (k > strL) {
            return false;
        }

        // 记录26个英文字母的单双情况
        boolean[] isSingleArr = new boolean[26];

        for (int i = 0; i < strL; i++) {
            int index = str.charAt(i) - 'a';
            isSingleArr[index] ^= true;
        }

        // 统计无法成对的单个字母数量
        int singleQty = 0;
        for (boolean isSingle : isSingleArr) {
            if(isSingle){
                singleQty += 1;
            }
        }

        // 若单个字母的数量不超过 k，则剩下的数，无论怎么组合，都可以构成所需要的回文串（成对的字母可以拆开来使用）
        return singleQty <= k;
    }

}
