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
        // 保证最高位都为1
        for (int[] a : A) {
            if (a[0] == 0) {
                for (int i = 0; i < column; i++) {
                    // 异或运算，相对应位的值相同则为0，否则为1
                    a[i] = a[i] ^ 1;
                }
            }
        }
        // 优化
        for (int i = 1; i < column; i++) {
            int k = 0;
            int reverseNum = 0;
            for (int[] ints : A) {
                if (ints[i] == 1) {
                    k++;
                } else {
                    reverseNum++;
                }
            }
            // 计算每列的和
            result += Math.max(k, reverseNum) * (1 << (column - 1 - i));
        }

        return result;
    }
}
