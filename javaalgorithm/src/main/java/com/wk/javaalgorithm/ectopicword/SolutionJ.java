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
                map.put(temp, list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 计数
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (int i = 0, n = str.length(); i < n; i++) {
                count[str.charAt(i) - 'a']++;
            }
            String key = new String(count, 0, 26);
            ArrayList<String> list = map.getOrDefault(key, null);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
