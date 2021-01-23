package com.wk.javaalgorithm.leetcode1319;


/**
 * 1319. 连通网络的操作次数
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * <p>
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * <p>
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 */
public class SolutionJ {
    public int makeConnected(int n, int[][] connections) {
        int length = connections.length;
        if (length < n - 1) {
            return -1;
        }
        Union union = new Union(n);
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            union.union(x,y);
        }
        return union.count - 1;
    }

    static class Union {
        int[] parent;
        int count;
        Union(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            count--;
        }
    }
}
