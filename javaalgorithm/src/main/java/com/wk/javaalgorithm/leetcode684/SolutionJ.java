package com.wk.javaalgorithm.leetcode684;

/**
 * 684. 冗余连接
 * 在本问题中, 树指的是一个连通且无环的无向图。
 * <p>
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * <p>
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 */
public class SolutionJ {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int index1 = edge[0];
            int index2 = edge[1];
            int rootX = find(parent, index1);
            int rootY = find(parent, index2);
            if (rootX != rootY) {
                union(parent, rootX, rootY);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    private void union(int[] parent, int rootX, int rootY) {
        parent[rootX] = rootY;
    }

    private int find(int[] parent, int i) {
        if (i != parent[i]) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }


}
