package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 * <p>
 * 示例:
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 * <p>
 * 说明:
 * 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
 * 1 <= citations.length <= 100000
 * 0 <= citations[i] <= 1000
 *
 * <p>
 * 进阶：
 * 这是 H 指数 的延伸题目，本题中的 citations 数组是保证有序的。
 * 你可以优化你的算法到对数时间复杂度吗？
 * <p>
 * 通过次数29,677提交次数66,872
 *
 * @author xiaohe
 * @time 2021.07.12 10:20
 */
public class T275H指数2 {

    /**
     * 二分法
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%
     * 的用户内存消耗：45.2 MB, 在所有 Java 提交中击败了77.70%的用户
     */
    public int hIndex(int[] citations) {

        // 定义数组取值的左右边界，区间：[0,n)
        int left = 0;
        int right = citations.length - 1;

        // 当循环结果时, left 即为结果
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (citations[mid] >= citations.length - mid) {
                // 符合, 若要 h 更大，则只有把 数组的拆分点往左找。
                right = mid - 1;

            } else {
                // 不符合
                left = mid + 1;
            }
        }

        return citations.length - left;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了29.19%的用户
     * 内存消耗：45.4 MB, 在所有 Java 提交中击败了30.63%的用户
     */
    public int hIndex2(int[] citations) {

        int n = citations.length;

        for (int h = n; h > 0; h--) {

            if (citations[n - h] >= h) {
                return h;
            }
        }

        return 0;
    }


}
