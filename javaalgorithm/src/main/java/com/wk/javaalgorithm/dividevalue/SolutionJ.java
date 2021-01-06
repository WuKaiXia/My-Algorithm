package com.wk.javaalgorithm.dividevalue;

import java.util.HashMap;
import java.util.List;

/**
 * leetcode 399 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * <p>
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * <p>
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 */
public class SolutionJ {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();

        UnionFind unionFind = new UnionFind(size * 2);

        HashMap<String, Integer> map = new HashMap<>(size * 2);
        int id = 0;
        for (int i = 0; i < size; i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {
        private final int[] parent;
        private final double[] weight;

        public UnionFind(int size) {
            parent = new int[size];
            weight = new double[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootY == rootX) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        private int find(int y) {
            if (y != parent[y]) {
                int origin = parent[y];
                parent[y] = find(parent[y]);
                weight[y] *= weight[origin];
            }
            return parent[y];
        }

        public double isConnected(Integer x, Integer y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0D;
            }
        }
    }
}
