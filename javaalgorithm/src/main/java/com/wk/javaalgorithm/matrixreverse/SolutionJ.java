package com.wk.javaalgorithm.matrixreverse;

/**
 * 861. 翻转矩阵后的得分
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 */
public class SolutionJ {

    public int matrixScore(int[][] A) {
        if (A == null || A.length < 1) return 0;
        int n = A.length, m = A[0].length;
        int result = (int) (Math.pow(2, m - 1) * n);
        // 保证最高位都为1
        for (int[] a : A) {
            if (a[0] == 0) {
                for (int i = 0; i < a.length; i++) {
                    // 异或运算，相对应位的值相同则为0，否则为1
                    a[i] = a[i] ^ 1;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            int count = 0;
            for (int[] ints : A) {
                if (ints[i] == 1) count++;
            }

            if (count < (n + 1) / 2) {
                for (int[] ints : A) {
                    ints[i] = ints[i] ^ 1;
                }
            }
            // 计算每列的和
            for (int[] ints : A) {
                result += ints[i] * Math.pow(2, m - 1 - i);
            }
        }

        return result;
    }
}
