package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * <p>
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * <p>
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * <p>
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * <p>
 * 通过次数276,305提交次数566,722
 *
 * @author xiaohe
 * @time 2021.04.15 14:20
 */
public class T198打家劫舍 {


    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {

            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;

        }

        return second;
    }

    /**
     * 遍历整个数组。记当前房间为的顺序 i，则选择当前房间的最大值为 MAX(max[i-2],max[i-1]) + nums[i]
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了53.88%的用户
     */
    public int rob2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] cache = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int j1 = i % 3;
            // 此处计算下标的方式很妙。
            // note : 当 j1 = 2时，j2就需要 = 0，然 2 + 1 = 3就越界了。因此先加1，再取余，便能取得 j2 = 0
            int j2 = (i + 1) % 3;
            cache[j1] = (cache[j1] > cache[j2] ? cache[j1] : cache[j2]) + nums[i];
        }

        int j1 = (nums.length - 1) % 3;
        int j2 = (nums.length - 2) % 3;

        return cache[j1] > cache[j2] ? cache[j1] : cache[j2];
    }
}
