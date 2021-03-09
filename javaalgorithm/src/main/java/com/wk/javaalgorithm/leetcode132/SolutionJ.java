package com.wk.javaalgorithm.leetcode132;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 */
public class SolutionJ {
    int n;
    int res;
    boolean[][] f;
    ArrayList<String> ans = new ArrayList<>();

    public int minCut(String s) {
        n = s.length();
        f = new boolean[n][n];
        res = n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
//        dfs(s, 0);
        int[] g = new int[n];
        Arrays.fill(g, n);
        for (int i = 0; i < n; i++) {
            if (f[0][i]) {
                g[i] = 0;
            } else {
                for (int j = 0; j < n; j++) {
                    if (f[j + 1][i]) {
                        g[i] = Math.min(g[i], g[j] + 1);
                    }
                }
            }
        }
        return g[n - 1];
    }

    // 超时
    private void dfs(String s, int i) {
        if (i == n) {
            res = Math.min(res, ans.size());
            return;
        }
        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
