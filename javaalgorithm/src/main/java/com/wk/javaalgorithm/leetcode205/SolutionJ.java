package com.wk.javaalgorithm.leetcode205;

import java.util.HashMap;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 */
public class SolutionJ {

    public static void main(String[] args) {
        isIsomorphic("ab", "aa");
    }

    public static boolean isIsomorphic(String s, String t) {
        int length = s.length();
        if (length != t.length()) return false;
        HashMap<Character, Character> s2TMap = new HashMap<>();
        HashMap<Character, Character> t2SMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            Character tempS = s2TMap.getOrDefault(chS, null);
            Character tempT = t2SMap.getOrDefault(chT, null);
            if ((tempS != null && tempS != chT) || (tempT != null && tempT != chS)) {
                return false;
            }
            s2TMap.put(chS, chT);
            t2SMap.put(chT, chS);
        }
        return true;
    }
}
