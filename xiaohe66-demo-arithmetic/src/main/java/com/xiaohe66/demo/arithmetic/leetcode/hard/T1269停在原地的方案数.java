package com.xiaohe66.demo.arithmetic.leetcode.hard;

/**
 * @author xiaohe
 * @time 2021.05.13 10:45
 */
public class T1269停在原地的方案数 {


    public int numWays(int steps, int arrLen) {
        int ret = 0;

        for (int i = 0; i <= steps; i++) {

        }


        return -1;
    }

    private int arrLen;
    private int[][] dp;
    private int max = 10 ^ 9 + 7;

    /**
     * 1.对于每一个下标i，他第1步可以为不动、向左、向右。剩余步数记为 n，则从i位，走n步移动到0处的可行方案为 f(i,n)
     *
     * <p>
     * f(0,0) = 1
     * f(i,n) = 0                                       i < 0 || i == arrLen || n == -1
     * f(i,n) = f(i-1,n-1) + f(i,n-1) + f(i+1,n-1)      i >= 0, i < arrLen, n > 0
     *
     * <p>
     * f(0,1) = 						1	停
     * f(0,2) = f(0,1) + f(1,1)		    2	停停，右左
     * f(0,3) = 						4	停停停，停右左，右左停，右停左
     */
    public int numWays2(int steps, int arrLen) {
        this.arrLen = arrLen;
        dp = new int[arrLen][steps + 1];
        return helper(0, steps);
    }

    /**
     * 提交结果：超出内存限制
     */
    private int helper(int i, int n) {

        if (i == 0 && n == 0) {
            return 1;
        }

        if (i < 0 || i >= arrLen || i > n) {
            return 0;
        }

        if (dp[i][n] == 0) {
            dp[i][n] = helper(i - 1, n - 1) + helper(i, n - 1);
            dp[i][n] = dp[i][n] % max;
            dp[i][n] += helper(i + 1, n - 1);
            dp[i][n] = dp[i][n] % max;
        }
        return dp[i][n];
    }
}
