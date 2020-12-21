package com.wk.javaalgorithm.mincost;

/**
 * 746. 使用最小花费爬楼梯
 *
 * 一次走一个或者两个台阶
 */
public class SolutionJ {

    /**
     * d[i] = min(d[i-2]+cost[i-2], d[i-1]+cost[i-1])
     * 动态规划
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(prev + cost[i - 2], curr + cost[i - 1]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
