package com.wk.javaalgorithm.leetcode1370;

/**
 * 1370. 上升下降字符串
 */
public class SolutionJ {

    public String sortString(String s) {

        if (s == null || s.isEmpty()) return s;
        int length = s.length();
        int[] ret = new int[26];
        for (int i = 0; i < length; i++) {
            ret[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length) {
            for (int i = 0; i < 26; i++) {
                if (ret[i] > 0) {
                    sb.append((char)(i + 'a'));
                    ret[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (ret[i] > 0) {
                    sb.append((char)(i + 'a'));
                    ret[i]--;
                }
            }
        }
        return sb.toString();
    }
}
