package com.wk.javaalgorithm.leetcode830;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. 较大分组的位置
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 */
public class SolutionJ {
    public List<List<Integer>> largeGroupPositions(String s) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        int start = 0, end = 0;
        char flag = s.charAt(0);
        for (int i = 1, n = s.length(); i < n; i++) {
            char ch = s.charAt(i);
            if (flag == ch) {
                end = i;
            } else {
                if (end - start >= 2) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    ret.add(list);
                }
                flag = ch;
                start = i;
                end = 0;
            }
        }
        if (end - start >= 2) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            ret.add(list);
        }
        return ret;
    }
}
