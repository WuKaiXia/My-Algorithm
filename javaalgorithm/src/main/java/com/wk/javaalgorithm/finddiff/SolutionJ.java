package com.wk.javaalgorithm.finddiff;

/**
 * 389. 找不同
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
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
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference0(String s, String t) {
        int as = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            as += (t.charAt(i) - s.charAt(i));
        }

        as += t.charAt(length);
        return (char) as;
    }

    /**
     * 1. 0^a=a
     * 2. a^a=0
     * 3. a^b^a = (a^a)^b
     * 基于上边三条规律
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public char findTheDifference1(String s, String t) {
        int ret = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            ret ^= s.charAt(i) ^ t.charAt(i);
        }

        ret ^= t.charAt(n);
        return (char) ret;
    }
}
