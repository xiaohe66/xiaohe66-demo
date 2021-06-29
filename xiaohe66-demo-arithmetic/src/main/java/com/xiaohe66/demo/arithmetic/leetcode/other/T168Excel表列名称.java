package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * @author xiaohe
 * @time 2021.06.29 09:57
 */
public class T168Excel表列名称 {

    /**
     * 核心：26进制，但26时不进，在27时进
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.3 MB, 在所有 Java 提交中击败了94.53%的用户
     */
    public String convertToTitle(int columnNumber) {

        StringBuilder stringBuilder = new StringBuilder();

        do {

            int i = columnNumber % 26;

            if (i == 0) {

                stringBuilder.append('Z');
                columnNumber = columnNumber / 26 - 1;
            } else {

                // @ = 'A' - 1
                stringBuilder.append((char) (i + '@'));
                columnNumber = columnNumber / 26;
            }


        } while (columnNumber != 0);

        stringBuilder.reverse();

        return stringBuilder.toString();
    }

}
