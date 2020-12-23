package com.wk.javaalgorithm.onlychar;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class SolutionJ {

    public int firstUniqChar(String s) {
        int[] table = new int[26];
        int res = s.length();
        for (int i = 0; i < res; i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int num = table[i];
            if (num == 1) {
                int index = s.indexOf((char) (i + 'a'));
                if (res != -1 && index < res) {
                    res = index;
                }
            }
        }
        return res == s.length() ? -1 : res;
    }
}
