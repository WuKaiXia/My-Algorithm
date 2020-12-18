package com.wk.javaalgorithm.finddiff;

/**
 * 389. 找不同
 */
public class SolutionJ {

    /**
     * 基于桶排序验证
     */
    public char findTheDifference(String s, String t) {
        int[] temp = new int[26];
        for (int i = 0, n = s.length(); i < n; i++) {
            temp[s.charAt(i) - 'a']++;
        }

        for (int i = 0, n = t.length(); i < n; i++) {
            temp[t.charAt(i) - 'a']--;
            if (temp[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return ' ';
    }
}
