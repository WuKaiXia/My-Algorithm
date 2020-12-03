package com.wk.javaalgorithm.primenum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 204. 计数质数
 */
public class SolutionJ {

    public static void main(String[] args) {

    }

    public static int primeNum(int n) {
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    // i*i, i*2i, i* 3i......
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    public static int primeNumOptimize(int n) {
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                list.add(i);
            }
            for (int j = 0; j < list.size() && i * list.get(j) < n; j++) {
                primes[i * list.get(j)] = 0;
                if (i % list.get(j) == 0) {
                    break;
                }
            }
        }
        return list.size();
    }
}
