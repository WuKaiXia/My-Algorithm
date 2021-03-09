package com.wk.javaalgorithm.leetcode1047;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class SolutionJ {

    public static String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        int top = -1;
        for (char c : chars) {
            if (top == -1 || chars[top] != c) {
                chars[++top] = c;
            } else {
                top--;
            }
        }
        return String.valueOf(chars, 0, top + 1);
    }
}
