package com.wk.javaalgorithm.leetcode547;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. 省份数量
 * <p>
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 */
public class SolutionJ {

    public int findCircleNum0(int[][] isConnected) {
        int res = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer num = queue.poll();
                    visited[num] = true;
                    for (int j = 0; j < n; j++) {
                        if (isConnected[num][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
                res++;
            }
        }
        return res;
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                res++;
            }
        }
        return res;
    }

    private void union(int[] parent, int i, int j) {
        parent[find(parent,i)] = find(parent,j);
    }

    private int find(int[] parent, int n) {
        if (parent[n] != n) {
            parent[n] = parent[find(parent,parent[n])];
        }
        return parent[n];
    }


}
