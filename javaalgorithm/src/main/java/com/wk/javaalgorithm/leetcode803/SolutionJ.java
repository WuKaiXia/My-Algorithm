package com.wk.javaalgorithm.leetcode803;

/**
 * 803. 打砖块
 * 有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
 * <p>
 * 一块砖直接连接到网格的顶部，或者
 * 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
 * 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
 * <p>
 * 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
 * <p>
 * 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
 */
public class SolutionJ {
    int rows;
    int cols;
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;
        int size = rows * cols;
        Union union = new Union(size + 1);

        int[][] copy = new int[rows][cols];
        // 复制网格数组
        for (int j = 0; j < rows; j++) {
            if (cols >= 0) System.arraycopy(grid[j], 0, copy[j], 0, cols);
        }
        // 根据hits敲碎所有相应位置上的石头
        for (int[] hit : hits) {
            int x = hit[0];
            int y = hit[1];
            copy[x][y] = 0;
        }

        for (int i = 0; i < cols; i++) {
            if (copy[0][i] == 1) {
                union.union(i, size);
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (copy[i][j] == 1) {
                    if (copy[i - 1][j] == 1) {
                        union.union(getIndex(i - 1, j), getIndex(i, j));
                    }
                    if (j > 0 && copy[i][j - 1] == 1) {
                        union.union(getIndex(i, j - 1), getIndex(i, j));
                    }
                }
            }
        }

        int len = hits.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) continue;

            int origin = union.getSize(size);
            if (x == 0) {
                union.union(y, size);
            }

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && copy[newX][newY] == 1) {
                    union.union(getIndex(x, y), getIndex(newX, newY));
                }
            }

            int current = union.getSize(size);
            res[i] = Math.max(0, current - origin - 1);
            copy[x][y] = 1;
        }

        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private int getIndex(int x, int y) {
        return x * cols + y;
    }

    class Union {
        int[] parent;
        int[] size;

        Union(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        private int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }
}
