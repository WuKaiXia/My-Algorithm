package com.wk.javaalgorithm.leetcode242;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * 242. 有效的字母异位词
 * 如： s = "anagram", t = "nagaram"  true
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            int count = map.getOrDefault(c, 0) - 1;
            if (count < 0) return false;
            map.put(c, count - 1);
        }
        return true;
    }
}
