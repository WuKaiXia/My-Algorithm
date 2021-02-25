package com.wk.javaalgorithm.leetcode867;

/**
 * 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 */
public class SolutionJ {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] transposes = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposes[j][i] = matrix[i][j];
            }
        }
        return transposes;
    }
}
