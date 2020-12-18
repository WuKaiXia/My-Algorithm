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
            char c = t.charAt(i);
            temp[c - 'a']--;
            if (temp[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 求和，算差值
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference0(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            as += s.charAt(i);
        }

        for (int i = 0, n = t.length(); i < n; i++) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }
}
