package com.wk.javaalgorithm.leetcode766;

/**
 * 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 */
public class SolutionJ {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            int x = matrix[i][0];
            int rowIndex = i + 1, colIndex = 1;
            while (colIndex < col && rowIndex < row) {
                if (x != matrix[rowIndex][colIndex]) return false;
                colIndex++;
                rowIndex++;
            }
        }

        for (int i = 1; i < col; i++) {
            int x = matrix[0][i];
            int rowIndex = 1, colIndex = i + 1;
            while (colIndex < col && rowIndex < row) {
                if (x != matrix[rowIndex][colIndex]) return false;
                colIndex++;
                rowIndex++;
            }
        }
        return true;
    }
}
