package com.xiaohe66.demo.arithmetic.leetcode.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * <p>
 * 小时不会以零开头：
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * 示例 1：
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * <p>
 * 示例 2：
 * 输入：turnedOn = 9
 * 输出：[]
 * <p>
 * 解释：
 * 0 <= turnedOn <= 10
 * 通过次数33,319提交次数59,037
 *
 * @author xiaohe
 * @time 2021.06.21 11:02
 */
public class T401二进制手表 {

    /**
     * 官方题解
     * <p>
     * 非常好理解……
     */
    public List<String> readBinaryWatch(int turnedOn) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {

                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {

                    list.add(i + ":" + (j < 10 ? ("0" + j) : j));

                }

            }
        }
        return list;
    }

}
