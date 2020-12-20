package com.wk.javaalgorithm.sameword;

/**
 * 316. 去除重复字母
 */
public class SolutionJ {

    /**
     * 获取的是无重复的有序字符串
     */
    public String removeDuplicateLetters(String s) {
        int[] temp = new int[26];
        for (int i = 0, n = s.length(); i < n; i++) {
            temp[s.charAt(i) - 'a']++;
        }

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (temp[i] > 0) {
                ret.append((char) (i + 'a'));
            }
        }
        return ret.toString();
    }
}
