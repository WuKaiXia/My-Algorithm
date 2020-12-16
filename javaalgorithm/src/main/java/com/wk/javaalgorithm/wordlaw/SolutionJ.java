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
}
