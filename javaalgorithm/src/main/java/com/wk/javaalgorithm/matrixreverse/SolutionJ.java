package com.wk.javaalgorithm.matrixreverse;

/**
 * 861. 翻转矩阵后的得分
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 */
public class SolutionJ {

    public int matrixScore(int[][] A) {
        if (A == null || A.length < 1) return 0;
        int row = A.length, column = A[0].length;
        int result = (1 << (column - 1)) * row;

        // 优化
        for (int i = 1; i < column; i++) {
            int k = 0;
            for (int[] ints : A) {
                // 该列所在的行需要进行反转
                if (ints[0] == 0) {
                    k += 1 - ints[i];
                } else {
                    k += ints[i];
                }
            }
            // 计算每列的和, 获取k与row - k中的最大值，巧妙的避免了列反转的判断
            result += Math.max(k, row - k) * (1 << (column - 1 - i));
        }

        return result;
    }
}
