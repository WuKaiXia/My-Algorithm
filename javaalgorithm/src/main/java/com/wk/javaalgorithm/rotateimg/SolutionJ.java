package com.wk.javaalgorithm.rotateimg;

/**
 * 48. 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 */
public class SolutionJ {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};
        rotate(matrix);
    }

    /**
     * 暴力解法
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ret = new int[n][n];
        int colum = n - 1;
        for (int[] array : matrix) {
            for (int i = 0; i < n; i++) {
                ret[i][colum] = array[i];
            }
            colum--;
        }
        System.arraycopy(ret, 0, matrix, 0, n);
    }
}
