package com.wk.javaalgorithm.leetcode135;

/**
 * 135. 分发糖果
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class SolutionJ {

    /**
     * 正序遍历，prev与当前比较，统计每个位置的糖果
     * 倒序遍历，after与当前比较，比较统计糖果数与计数
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int ret = 0, right = 1;
        for (int i = n - 1; i > -1; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    public int candy1(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, prev = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                ret += prev;
                inc = prev;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                prev = 1;
            }
        }
        return ret;
    }
}
