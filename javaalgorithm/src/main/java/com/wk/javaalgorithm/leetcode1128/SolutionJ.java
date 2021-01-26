package com.wk.javaalgorithm.leetcode1128;

/**
 * 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * <p>
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 */
public class SolutionJ {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] copy = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int x = domino[0];
            int y = domino[1];
            int num = x > y ? x * 10 + y : y * 10 + x;
            ret += copy[num];
            copy[num]++;
        }
        return ret;
    }
}
