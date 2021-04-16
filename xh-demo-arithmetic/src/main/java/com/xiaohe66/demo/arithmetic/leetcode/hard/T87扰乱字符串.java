package com.xiaohe66.demo.arithmetic.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 * <p>
 * 示例 1：
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 *
 * <p>
 * 解释：s1 上可能发生的一种情形是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
 * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 *
 * <p>
 * 示例 2：
 * 输入：s1 = "abcde", s2 = "caebd"
 * 输出：false
 *
 * <p>
 * 示例 3：
 * 输入：s1 = "a", s2 = "a"
 * 输出：true
 *
 * <p>
 * 提示：
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 和 s2 由小写英文字母组成
 *
 * <p>
 * 通过次数20,602提交次数42,388
 *
 * @author xiaohe
 * @time 2021.04.16 09:46
 */
public class T87扰乱字符串 {

    /*
     * 这是一个难度为困难的题目
     * 可以很容易的想到递归的条件，此外重点在于找到节省时间的类似
     * 1. 两边的串中的某个字符数量不同，则无论怎么翻转都不可能相同
     * 2. 将计算过的字符结果保存起来，可节省大量重复运算
     * 3.
     */

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了79.31%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了9.14%的用户
     */
    public static class Impl {

        int[][][] cache;
        int[] qty;

        public boolean isScramble(String s1, String s2) {

            int len = s1.length();
            cache = new int[len][len][len + 1];
            qty = new int[26];

            return isScramble(s1, s2, 0, 0, len);
        }

        public boolean isScramble(String s1, String s2, int start1, int start2, int len) {
            if (len == 1) {
                return s1.charAt(start1) == s2.charAt(start2);
            }

            if (cache[start1][start2][len] != 0) {
                return cache[start1][start2][len] == 1;
            }

            if (!checkQty(s1, s2, start1, start2, len)) {
                cache[start1][start2][len] = -1;
                return false;
            }


            for (int i = 1; i < len; i++) {

                if (isScramble(s1, s2, start1, start2, i) &&
                        isScramble(s1, s2, start1 + i, start2 + i, len - i)) {

                    cache[start1][start2][len] = 1;
                    return true;
                }

                if (isScramble(s1, s2, start1, start2 + len - i, i) &&
                        isScramble(s1, s2, start1 + i, start2, len - i)) {

                    cache[start1][start2][len] = 1;
                    return true;
                }
            }
            cache[start1][start2][len] = -1;
            return false;
        }

        public boolean checkQty(String s1, String s2, int start1, int start2, int len) {
            Arrays.fill(qty, 0);

            for (int i = 0; i < len; i++) {
                qty[s1.charAt(start1 + i) - 'a']++;
                qty[s2.charAt(start2 + i) - 'a']--;
            }
            for (int i : qty) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 在impl2的基础上，增加的数量判断机制。当字段的数量不等时，直接返回false
     *
     * <p>
     * 执行用时：5 ms, 在所有 Java 提交中击败了75.14%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了20.35%的用户
     */
    public static class Impl3 {

        Map<Key, Boolean> cache = new HashMap<>();
        int[] qty = new int[26];

        public boolean isScramble(String s1, String s2) {

            int len = s1.length();

            if (len == 1) {
                return s1.equals(s2);
            }

            if (!checkQty(s1, s2)) {
                return false;
            }

            Key key = new Key(s1, s2);

            Boolean result = cache.get(key);
            if (result != null) {
                return result;
            }

            boolean ret = false;
            for (int mid = 1; mid < len; mid++) {

                String s1Before = s1.substring(0, mid);
                String s2Before = s2.substring(0, mid);

                String s1After = s1.substring(mid);
                String s2After = s2.substring(mid);

                if (isScramble(s1Before, s2Before) && isScramble(s1After, s2After)) {
                    ret = true;
                    break;
                }

                int newMid = len - mid;

                s1After = s1.substring(0, newMid);
                s1Before = s1.substring(newMid);

                if (isScramble(s1Before, s2Before) && isScramble(s1After, s2After)) {
                    ret = true;
                    break;
                }
            }
            if (s1.length() > 1) {
                cache.put(key, ret);
            }
            return ret;
        }

        public boolean checkQty(String s1, String s2) {
            Arrays.fill(qty, 0);
            for (int i = 0, len = s1.length(); i < len; i++) {
                qty[s1.charAt(i) - 'a']++;
                qty[s2.charAt(i) - 'a']--;
            }
            for (int i : qty) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * 执行用时：82 ms, 在所有 Java 提交中击败了5.20%的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了5.21%的用户
     */
    public static class Impl2 {

        public boolean isScramble(String s1, String s2) {
            return isScramble(new Key(s1, s2), new HashMap<>());
        }

        public boolean isScramble(Key key, Map<Key, Boolean> maybeMap) {

            if (key.s1.length() == 1) {
                return key.s1.equals(key.s2);
            }

            Boolean result = maybeMap.get(key);
            if (result != null) {
                return result;
            }

            boolean ret = false;
            for (int mid = 1; mid < key.s1.length(); mid++) {

                String s1Before = key.s1.substring(0, mid);
                String s2Before = key.s2.substring(0, mid);

                String s1After = key.s1.substring(mid);
                String s2After = key.s2.substring(mid);

                if (isScramble(new Key(s1Before, s2Before), maybeMap) && isScramble(new Key(s1After, s2After), maybeMap)) {
                    ret = true;
                    break;
                }

                int newMid = key.s1.length() - mid;

                s1After = key.s1.substring(0, newMid);
                s1Before = key.s1.substring(newMid);

                if (isScramble(new Key(s1Before, s2Before), maybeMap) && isScramble(new Key(s1After, s2After), maybeMap)) {
                    ret = true;
                    break;
                }
            }
            if (key.s1.length() > 1) {
                maybeMap.put(key, ret);
            }


            return ret;
        }

    }

    private static class Key {

        private String s1;
        private String s2;

        public Key(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (s1 != null ? !s1.equals(key.s1) : key.s1 != null) return false;
            return s2 != null ? s2.equals(key.s2) : key.s2 == null;
        }

        @Override
        public int hashCode() {
            int result = s1 != null ? s1.hashCode() : 0;
            result = 31 * result + (s2 != null ? s2.hashCode() : 0);
            return result;
        }
    }

}
