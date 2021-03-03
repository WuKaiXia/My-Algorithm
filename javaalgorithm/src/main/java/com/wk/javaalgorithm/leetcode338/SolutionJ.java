package com.wk.javaalgorithm.leetcode338;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class SolutionJ {

    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

    /**
     * 最低有效位，bits[x] = bits[2/x] + (x/2)
     * 其中x/2 = x & 1
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    /**
     * 最高有效位  bits[x] = bits[x - highBit] + 1
     *
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public int[] countBits3(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private int countOnes(int i) {
        int ones = 0;
        while (i > 0) {
            i &= (i - 1);
            ones++;
        }
        return ones;
    }
}
