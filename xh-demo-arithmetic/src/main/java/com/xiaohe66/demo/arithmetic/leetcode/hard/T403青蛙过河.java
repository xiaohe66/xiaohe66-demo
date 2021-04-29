package com.xiaohe66.demo.arithmetic.leetcode.hard;

/**
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * <p>
 * 示例 1：
 * 输入：stones = [0,1,3,5,6,8,12,17]
 * 输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
 *
 * <p>
 * 示例 2：
 * 输入：stones = [0,1,2,3,4,8,9,11]
 * 输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 *
 * <p>
 * 提示：
 * 2 <= stones.length <= 2000
 * 0 <= stones[i] <= 231 - 1
 * stones[0] == 0
 *
 * <p>
 * 通过次数17,859提交次数42,890
 *
 * @author xiaohe
 * @time 2021.04.29 09:42
 */
public class T403青蛙过河 {

    private int[] stones;
    private int right;
    private Boolean[][] cache;

    /**
     * 执行用时：29 ms, 在所有 Java 提交中击败了87.43%的用户
     * 内存消耗：60.2 MB, 在所有 Java 提交中击败了5.07%的用户
     */
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }

        this.stones = stones;
        right = stones.length - 1;
        cache = new Boolean[stones.length][stones.length];

        return helper(1, 1);
    }

    private boolean helper(int i, int prev) {

        if (i == right) {
            return true;
        }
        if (cache[i][prev] != null) {
            return cache[i][prev];
        }

        int left = i + 1;

        int index = find(prev + stones[i], left, right);
        if (index != -1 && helper(index, prev)) {
            cache[i][prev] = true;
            return true;
        }
        index = find(prev + 1 + stones[i], left, right);
        if (index != -1 && helper(index, prev + 1)) {
            cache[i][prev] = true;
            return true;
        }
        if (prev > 1) {
            index = find(prev - 1 + stones[i], left, right);
            if (index != -1 && helper(index, prev - 1)) {
                cache[i][prev] = true;
                return true;
            }
        }

        cache[i][prev] = false;
        return false;
    }

    private int find(int num, int left, int right) {

        while (left <= right) {

            int mid = (left + right) / 2;

            if (stones[mid] == num) {
                return mid;

            } else if (stones[mid] > num) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }

        }
        return -1;
    }
}
