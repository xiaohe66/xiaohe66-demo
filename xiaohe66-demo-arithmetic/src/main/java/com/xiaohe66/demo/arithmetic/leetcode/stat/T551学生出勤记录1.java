package com.xiaohe66.demo.arithmetic.leetcode.stat;

/**
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * <p>
 * 示例 2：
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 为 'A'、'L' 或 'P'
 * <p>
 * 通过次数35,472提交次数64,747
 *
 * @author xiaohe
 * @since 2021.08.17 09:56
 */
public class T551学生出勤记录1 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了41.71%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了66.00%的用户
     */
    public boolean checkRecord(String s) {

        // todo : 改为快速失败可提高效率

        int a = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                if (++l >= 3) {
                    return false;
                }
            } else {
                l = 0;
            }
            if (c == 'A') {
                a++;
            }
        }

        return a < 2;
    }
}
