package com.wk.javaalgorithm.leetcode839;

/**
 * 839. 相似字符串组
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 * <p>
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 * <p>
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 * <p>
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 */
public class SolutionJ {
    int[] parent;

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = find(i);
                int fj = find(j);
                if (fi == fj) {
                    continue;
                }
                if (checkStr(strs[i], strs[j], m)) {
                    parent[fi] = fj;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) {
                ret++;
            }
        }
        return ret;
    }

    int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    boolean checkStr(String str1, String str2, int n) {
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                m++;
                if (m > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
