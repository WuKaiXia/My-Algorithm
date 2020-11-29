package com.wk.javaalgorithm.norepeatestr;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        HashSet<Character> set = new HashSet<>();
        int rk = -1;
        int ans = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk + 1 - i);
        }
        return ans;
    }
}
