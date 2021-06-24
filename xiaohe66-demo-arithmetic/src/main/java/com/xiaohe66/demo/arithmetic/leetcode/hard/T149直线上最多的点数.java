package com.xiaohe66.demo.arithmetic.leetcode.hard;

/**
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * <p>
 * 提示：
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 * <p>
 * 通过次数28,830提交次数102,225
 *
 * @author xiaohe
 * @time 2021.06.24 10:50
 */
public class T149直线上最多的点数 {

    /**
     * 暴力解法，思路来自宫水三叶：
     * 先确定2个点来构成一条直线，然后找到这条直线上的所有点进行统计。
     * <p>
     * 执行用时：3 ms, 在所有 Java 提交中击败了99.91%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了94.46%的用户
     */
    public int maxPoints(int[][] points) {

        int n = points.length;
        int ret = 1;
        for (int i = 0; i < n; i++) {

            int[] a = points[i];

            for (int j = i + 1; j < n; j++) {

                int[] b = points[j];

                int x = b[0] - a[0];
                int y = b[1] - a[1];
                int sum = 2;

                for (int k = j + 1; k < n; k++) {

                    int[] c = points[k];

                    /*
                        其实是判断比例是否一样，由于除法会造成精度丢失。因此改用乘法。
                        a / b = c / d，约去分母后 ==> b * c = a * d
                     */
                    int i1 = y * (c[0] - b[0]);
                    int i2 = x * (c[1] - b[1]);
                    if (i1 == i2) {
                        sum++;
                    }
                }

                if (sum > ret) {
                    ret = sum;
                }
            }
        }

        return ret;
    }
}
