package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * <p>
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 * <p>
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * <p>
 * 通过次数270,174提交次数591,595
 *
 * @author xiaohe
 * @time 2021.04.01 16:14
 */
public class T66加一 {

    /**
     * 难点在于进位。
     * 思路：后末尾开始遍历，当数字不是9时，则说明不需要进位。最终标记不需要进位的下标数加1，该数的右边全部设置为0
     *
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了29.38%的用户
     */
    public int[] plusOne(int[] digits) {

        int i;
        for (i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                break;
            }
        }

        if (i == -1) {

            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;

        } else {

            int[] ret = new int[digits.length];
            System.arraycopy(digits, 0, ret, 0, i + 1);
            ret[i] = ret[i] + 1;

            return ret;
        }
    }
}
