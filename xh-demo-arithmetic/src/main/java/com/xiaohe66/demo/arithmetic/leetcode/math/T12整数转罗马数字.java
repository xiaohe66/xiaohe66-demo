package com.xiaohe66.demo.arithmetic.leetcode.math;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 * <p>
 * 示例 1:
 * 输入: num = 3
 * 输出: "III"
 *
 * <p>
 * 示例 2:
 * 输入: num = 4
 * 输出: "IV"
 *
 * <p>
 * 示例 3:
 * 输入: num = 9
 * 输出: "IX"
 *
 * <p>
 * 示例 4:
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * <p>
 * 示例 5:
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 * <p>
 * 提示：
 * 1 <= num <= 3999
 * 通过次数169,935提交次数259,612
 *
 * @author xiaohe
 * @time 2021.05.14 13:44
 */
public class T12整数转罗马数字 {

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了95.42%的用户
     */
    public String intToRoman(int num) {

        StringBuilder ret = new StringBuilder();

        helper(ret, num / 1000, 'M', 'M', 'M');
        num = num % 1000;

        helper(ret, num / 100, 'C', 'D', 'M');
        num = num % 100;

        helper(ret, num / 10, 'X', 'L', 'C');
        helper(ret, num % 10, 'I', 'V', 'X');


        return ret.toString();
    }

    private void helper(StringBuilder ret, int n, char one, char five, char ten) {
        if (n == 9) {
            ret.append(one);
            ret.append(ten);
        } else if (n >= 5) {
            ret.append(five);
            for (int i = 0; i < n - 5; i++) {
                ret.append(one);
            }
        } else if (n == 4) {
            ret.append(one);
            ret.append(five);
        } else {
            for (int i = 0; i < n; i++) {
                ret.append(one);
            }
        }
    }
}
