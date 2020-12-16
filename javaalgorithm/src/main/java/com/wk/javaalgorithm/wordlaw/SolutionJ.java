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
        String[] tokens = s.split(" ");
        int length = tokens.length;
        if (length != pattern.length()) return false;
        HashMap<Character, String> char2Str = new HashMap<>();
        HashMap<String, Character> str2Char = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String str = tokens[i];
            String temp = char2Str.getOrDefault(ch, null);
            Character tempCh = str2Char.getOrDefault(str, null);
            if ((temp != null && !str.equals(temp)) || (tempCh != null && tempCh != ch)) {
                return false;
            }
            char2Str.put(ch, str);
            str2Char.put(str, ch);
        }
        return true;
    }
}
