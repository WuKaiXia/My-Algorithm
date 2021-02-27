package com.wk.javaalgorithm.leetcode395;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 */
public class SolutionJ {
    public int longestSubstring(String s, int k) {
        return dfs(s,0, s.length() - 1, k);
    }

    private int dfs(String s, int l, int r, int k) {
        int[] cont = new int[26];
        for (int i = l; i <= r; i++) {
            cont[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            int count = cont[i];
            if (count > 0 && count < k) {
                split = (char)(i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }
        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split){
                i++;
            }
            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }
}
