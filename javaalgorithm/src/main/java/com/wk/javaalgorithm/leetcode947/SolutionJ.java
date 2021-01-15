package com.wk.javaalgorithm.leetcode947;

import java.util.HashMap;

/**
 * 947. 移除最多的同行或同列石头
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * <p>
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * <p>
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 */
public class SolutionJ {

    int count = 0;
    HashMap<Integer, Integer> parent = new HashMap<>();

    public int removeStones(int[][] stones) {

        for (int[] stone : stones) {
            union(~stone[0], stone[1]);
        }
        return stones.length - count;
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }
        parent.put(rootX, rootY);
        count--;
    }

    int find(int index) {
        if (!parent.containsKey(index)) {
            parent.put(index, index);
            count++;
        }
        if (index != parent.get(index)) {
            parent.put(index, find(parent.get(index)));
        }
        return parent.get(index);
    }
}
