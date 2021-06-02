package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 难度：困难
 *
 * <p>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * <p>
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * <p>
 * 通过次数44,288提交次数112,135
 *
 * @author xiaohe
 * @time 2020.11.04 15:34
 */
public class T57插入区间 {


    public int[][] insert(int[][] intervals, int[] newInterval) {

        int f = 0;
        for (; f < intervals.length; f++) {
            if (intervals[f][0] > newInterval[0]) {

                if (f != 0 && intervals[f - 1][0] < newInterval[0]) {
                    // 把 f 节点改成 newInterval[0]
                } else {
                    // 把 f -1 节点改成 newInterval[0]
                }
                break;
            }
        }
        int t;
        for (t = intervals.length - 1; t >= 0; t--) {

            if (intervals[t][1] < newInterval[1]) {

                if (t != intervals.length - 1 && intervals[t + 1][0] > newInterval[1]) {
                    // 把 t 节点改成 newInterval[1]
                } else {
                    // 使用 t + 1 节点
                }
                break;
            }
        }


        return null;
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {

        int first = find(intervals, newInterval[0], 0);
        int tail = find(intervals, newInterval[1], 1);

        boolean fnew = false;
        boolean tnew = false;

        if (first > 0 && intervals[first - 1][1] >= newInterval[0]) {
            first -= 1;
        } else if (intervals[first][0] > newInterval[0]) {
            fnew = true;
        }
        if (first > 0 && intervals[tail - 1][1] == newInterval[1]) {
            tail -= 1;
        } else if (first > 0 && intervals[tail - 1][1] == newInterval[1]) {
            tnew = true;
        }


        int sub = tail - first;
        int len = intervals.length - tail + first + (fnew || tnew ? 1 : 0);

        int[][] ret = new int[len][2];

        for (int i = 0; i <= first; i++) {
            ret[i] = new int[]{intervals[i][0], intervals[i][1]};
        }

        for (int i = tail; i < intervals.length; i++) {
            ret[i - sub] = new int[]{intervals[i][0], intervals[i][1]};
        }


        System.out.println("f: " + first + ",t:" + tail);
        System.out.println("fnew: " + fnew + ",tnew:" + tnew);

        return ret;
    }

    public int find(int[][] intervals, int num, int i) {
        int low = 0;
        int high = intervals.length;
        int end = high;
        int middle = 0;

        while (high > low) {

            middle = (low + high) / 2;

            if (num == intervals[middle][0]) {
                return middle;
            }

            if (num < intervals[middle][0]) {

                high = middle - 1;
            } else {

                low = middle + 1;
            }
        }

        // 保证复制的元素数量 大于 1
        if (end > low) {

            if (high == low && intervals[middle][i] < num) {
                low++;
            }
        }
        return low;
    }

}
