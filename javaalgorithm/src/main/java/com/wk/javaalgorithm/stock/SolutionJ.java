package com.wk.javaalgorithm.stock;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class SolutionJ {

    /**
     * 贪心， 只要比前一天的价格高就卖掉，累加差值就是最大收益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1, n = prices.length; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // 0: 当天手里没有股票时的收益；1：当天手里有股票时的收益
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        // 买股票
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 前一天没有股票时的收益与前一天有股票时的收益+今天卖出-fee的和相比较的最大值为当天手里没股票时的最大收益
            dp[i][0] = Math.max(prices[i] + dp[i - 1][1] - fee, dp[i - 1][0]);
            // 前一天有股票的收益与前一天没有股票收益-当天购买股票价格相比较
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }
}
