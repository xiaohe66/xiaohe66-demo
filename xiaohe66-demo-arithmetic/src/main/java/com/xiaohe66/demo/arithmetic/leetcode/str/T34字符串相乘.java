package com.xiaohe66.demo.arithmetic.leetcode.str;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * 1.num1 和 num2 的长度小于110。
 * 2.num1 和 num2 只包含数字 0-9。
 * 3.num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 4.不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author xiaohe
 * @time 2020.08.13 10:10
 */
public class T34字符串相乘 {

    String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }

        // 存放结果的数组，长度取两数相乘所得的最大位数，如2个3位数相乘，最大数位是 999 * 999 = 6，即是2数的长度之和
        int[] ret = new int[num1.length() + num2.length()];

        // 计算，仅计算每1位的值，当值超过10时不进位，进位在后面统一处理
        // 从个位开始计算，计算结果以逆序存放于 ret数组中
        // todo : 考虑正序存放的可实现性
        for (int i = num1.length(); i > 0; i--) {
            int index = num1.length() - i;
            int n1 = num1.charAt(i - 1) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {

                int index2 = num2.length() - j - 1;
                int n2 = num2.charAt(j) - '0';

                ret[index + index2] += n1 * n2;
            }
        }

        // 取得未进位时的最大位数
        int maxIndex = ret.length - 1;
        for (; maxIndex >= 0; maxIndex--) {
            if (ret[maxIndex] != 0) {
                break;
            }
        }

        // 进位，仅处理到未进位时的最大位数
        // 同时将值修改成 char的值，以便于后面直接使用 new String(int[],int,int)方法
        for (int i = 0; i <= maxIndex; i++) {
            if (ret[i] > 9) {
                ret[i + 1] += ret[i] / 10;
                ret[i] = ret[i] % 10;
            }
            ret[i] += 48;
        }

        // 大于未进位时的位数，在这里特殊处理
        for (maxIndex += 1; ; maxIndex++) {
            if (maxIndex >= ret.length || ret[maxIndex] == 0) {
                maxIndex -= 1;
                break;
            }
            ret[maxIndex] += 48;
        }

        // 翻转数组
        // todo : 考虑正序实现
        if (maxIndex == 0) {
            return new String(ret, 0, 1);
        }

        int c = maxIndex / 2;

        int tmp;
        for (int i = 0; i <= c; i++) {
            tmp = ret[maxIndex - i];
            ret[maxIndex - i] = ret[i];
            ret[i] = tmp;
        }

        return new String(ret, 0, maxIndex + 1);
    }

}
