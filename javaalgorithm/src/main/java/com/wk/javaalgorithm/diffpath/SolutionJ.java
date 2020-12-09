package com.wk.javaalgorithm.diffpath;

import java.util.Arrays;

/**
 * leetcode 62. 不同路径
 */
public class SolutionJ {

    /**
     * 向左或者向下移动，f(i,j) = f(i-1,j)+f(i,j-1)
     * 其中边界为1，即f(0,j)=f(i,0)=1
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths0(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 总共需移动m+n-2次，向下m-1次，向右n-1次
     * 所以结果是(m+n-2)!/(m-1)!(n-1)!
     */
    public int uniquePaths1(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; y++, x++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
