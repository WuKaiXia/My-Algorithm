package com.wk.javaalgorithm.leetcode1030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 距离顺序排列矩阵单元格
 * <p>
 * 曼哈顿距离，|r1 - r2| + |c1 - c2|
 */
public class Solution {


    public int[][] allCellsDistOrder(int R, int C, final int r0, final int c0) {
        int[][] result = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return dist(ints[0], ints[1], r0, c0) - dist(t1[0], t1[1], r0, c0);
            }
        });
        return result;
    }

    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<ArrayList<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dist = dist(i, j, r0, c0);
                bucket.get(dist).add(new int[]{i, j});
            }
        }

        int[][] result = new int[R * C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                result[index++] = it;
            }
        }

        return result;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}


