package com.xiaohe66.demo.arithmetic.leetcode.bit;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * <p>
 * 示例:
 * 输入: x = 1, y = 4
 *
 * <p>
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * *      ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * <p>
 * 通过次数123,326提交次数153,992
 *
 * @author xiaohe
 * @time 2021.05.27 09:50
 */
public class T461汉明距离 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35 MB , 在所有 Java 提交中击败了85.78%的用户
     */
    public int hammingDistance(int x, int y) {
        x = x ^ y;
        int ret = 0;

        while (x != 0) {
            ret += (x & 1);
            x = x >> 1;
        }
        return ret;
    }
}
