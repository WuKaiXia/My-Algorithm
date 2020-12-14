package com.wk.javaalgorithm.ectopicword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 */
public class SolutionJ {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            ArrayList<String> list = map.getOrDefault(temp, null);
            if (list == null) {
                list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            } else {
                list.add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
