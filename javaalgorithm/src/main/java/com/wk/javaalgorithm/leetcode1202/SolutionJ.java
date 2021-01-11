package com.wk.javaalgorithm.leetcode1202;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;

/**
 * 1202. 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * <p>
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * <p>
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 */
public class SolutionJ {

    public static void main(String[] args) {
        String st = "dcab";
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(3);
        list.add(integers);
        integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        list.add(integers);
        smallestStringWithSwaps(st,list);
//                [[0, 3],[1, 2]]
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) return s;
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair :
                pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            unionFind.union(x, y);
        }

        char[] charArray = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
//            char c = charArray[i];
            int root = unionFind.find(i);
            map.computeIfAbsent(root, integer -> new PriorityQueue<>()).offer(charArray[i]);
//            if (map.containsKey(root)) {
//                map.get(root).offer(c);
//            } else {
//                PriorityQueue<Character> qu = new PriorityQueue<>();
//                qu.offer(c);
//                map.put(root, qu);
//            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootX]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
        }

        public int find(int index) {
            if (index != parent[index]) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }
}
