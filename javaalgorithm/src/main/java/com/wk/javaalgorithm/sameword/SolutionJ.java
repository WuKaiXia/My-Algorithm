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

    /**
     * @return 无重复，且字典序最小的字符串
     */
    public String removeDuplicateLetters1(String s) {
        // 存储字符出现的次数
        int[] temp = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            temp[s.charAt(i) - 'a']++;
        }

        StringBuilder ret = new StringBuilder();
        // 用来记录ret中是否存在字符ch
        boolean[] booleans = new boolean[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            // ret中是否有字符ch，false：没有
            if (!booleans[index]) {
                char tempCh;
                // ret中有字符ch，但字典序不是最小就剔除
                while (ret.length() > 0 && (tempCh = ret.charAt(ret.length() - 1)) > ch && temp[tempCh - 'a'] > 0) {
                    // 剔除该字符
                    ret.deleteCharAt(ret.length() - 1);
                    // 标记成ret没有该字符，否则后续该字符无法添加
                    booleans[tempCh - 'a'] = false;
                }
                // 标记ret中已添加字符ch
                booleans[index] = true;
                ret.append(ch);
            }
            temp[index]--;
        }
        return ret.toString();
    }
}
