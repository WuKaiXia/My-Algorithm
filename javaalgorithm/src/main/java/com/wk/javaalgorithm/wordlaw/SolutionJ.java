package com.wk.javaalgorithm.wordlaw;

import java.util.HashMap;

/**
 * 290. 单词规律
 */
public class SolutionJ {

    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        int length = array.length;
        if (length != pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String str = array[i];
            char c = pattern.charAt(i);
            String temp = map.getOrDefault(c, null);
            if (temp == null) {
                if (map.containsValue(str)) {
                    return false;
                }
                map.put(c, str);
            } else if (!temp.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        HashMap<Character, String> char2Str = new HashMap<>();
        HashMap<String, Character> str2Char = new HashMap<>();
        int i = 0, strLength = s.length();
        for (int p = 0; p < pattern.length(); p++) {
            // 防止p的长度大于s以空格分开的数组长度
            if (i >= strLength) {
                return false;
            }
            char ch = pattern.charAt(p);
            // 字符串startIndex
            int j = i;
            while (j < strLength && s.charAt(j) != ' ') {
                j++;
            }
            String str = s.substring(i, j);
            String temp = char2Str.getOrDefault(ch, null);
            Character tempCh = str2Char.getOrDefault(str, null);
            if ((temp != null && !str.equals(temp)) || (tempCh != null && tempCh != ch)) {
                return false;
            }
            char2Str.put(ch, str);
            str2Char.put(str, ch);
            // 下轮的字符串startIndex
            i = j + 1;
        }
        return i >= strLength;
    }
}
