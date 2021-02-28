package com.wk.javaalgorithm.leetcode896;

/**
 * 896. 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 */
public class SolutionJ {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        boolean isIncrease;
        if (A[n - 1] - A[0] > 0) {
            isIncrease = true;
        } else {
            isIncrease = false;
        }
        for (int i = 0; i < n - 1; i++) {
            if (isIncrease) {
                if (A[i + 1] - A[i] < 0) {
                    return false;
                }
            } else {
                if (A[i + 1] - A[i] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
