package com.wk.javaalgorithm.leetcode509;

/**
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 */
public class SolutionJ {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * O(n)空间，遍历求值
     *
     * @param n
     * @return
     */
    public int fib0(int n) {
        int[] ret = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                ret[i] = 1;
                continue;
            }
            ret[i] = ret[i - 1] + ret[i - 2];
        }
        return ret[n];
    }

    public int fib1(int n) {
        if (n < 2) return n;
        int x = 0, y = 1;
        int ret = 0;
        for (int i = 2; i < n + 1; i++) {
            ret = x + y;
            x = y;
            y = ret;
        }
        return ret;
    }

    public int fib2(int n) {
        int first = 0, second = 1;

        while (n-- > 0) {
            second += first;
            first = second - first;
        }
        return first;
    }
}
