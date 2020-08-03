package com.xiaohe66.demo.arithmetic.leetcode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * <ul>
 * <li>num1 和num2 的长度都小于 5100.</li>
 * <li>num1 和num2 都只包含数字 0-9.</li>
 * <li>num1 和num2 都不包含任何前导零。</li>
 * <li>不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。</li>
 * </ul>
 *
 * <a href="https://leetcode-cn.com/problems/add-strings">https://leetcode-cn.com/problems/add-strings</a>
 *
 * @author xiaohe
 * @time 2020.08.03 14:24
 */
public class 字符串相加 {

    public static String addStrings(String num1, String num2) {

        int length1 = num1.length();
        int length2 = num2.length();
        int maxLength = length1 > length2 ? length1 : length2;
        int retLength = maxLength + 1;

        char[] ret = new char[retLength];
        int nextBit = 0;
        for (int i = 1; i <= maxLength; i++) {
            int i1 = length1 - i;
            int i2 = length2 - i;
            char tmp1 = i1 < 0 ? '0' : num1.charAt(i1);
            char tmp2 = i2 < 0 ? '0' : num2.charAt(i2);
            int sum = tmp1 + tmp2 + nextBit - '0';
            if (sum > 57) {
                nextBit = 1;
                ret[retLength - i] = (char) (sum - 10);
            } else {
                nextBit = 0;
                ret[retLength - i] = (char) sum;
            }
        }

        if (nextBit != 0) {
            ret[0] = (char) (nextBit + '0');
            return new String(ret);
        } else {
            return new String(ret, 1, maxLength);
        }
    }

    public static void test(String num1, String num2) {
        System.out.println("\t" + num1);
        System.out.println("\t" + num2);
        String ret = addStrings(num1, num2);
        System.out.println("\t" + ret);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {

        String num1;
        String num2;


        num1 = "999989";
        num2 = "11";
        test(num1, num2);

        num1 = "11";
        num2 = "98765";
        test(num1, num2);

    }

}
