package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 * <p>
 * 示例 1:
 * 输入: columnTitle = "A"
 * 输出: 1
 *
 * <p>
 * 示例 2:
 * 输入: columnTitle = "AB"
 * 输出: 28
 *
 * <p>
 * 示例 3:
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * <p>
 * 示例 4:
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 * <p>
 * 提示：
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 * <p>
 * 通过次数85,225提交次数120,946
 *
 * @author xiaohe
 * @time 2021.07.30 10:17
 */
public class T171Excel表列序号 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了67.34%的用户
     */
    public int titleToNumber(String columnTitle) {

        int multiple = 1;
        int n = columnTitle.length();
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            sum += num * multiple;
            multiple *= 26;
        }

        return sum;
    }
}
