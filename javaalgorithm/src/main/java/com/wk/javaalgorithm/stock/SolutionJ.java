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
        // sell: 当天手里没有股票时的收益；buy：当天手里有股票时的收益
        int[][] dp = new int[n][2];
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; i++) {
            // 前一天没有股票时的收益与前一天有股票时的收益+今天卖出-fee的和相比较的最大值为当天手里没股票时的最大收益
            sell = Math.max(prices[i] + buy - fee, sell);
            // 前一天有股票的收益与前一天没有股票收益-当天购买股票价格相比较
            buy = Math.max(sell - prices[i], buy);
        }
        return sell;
    }

    /**
     *
     * @param prices [1, 3, 7, 10, 5]
     * @param fee 3
     * @return
     *
     * 当第3天时卖出股票获得利润3，并记录此时的价格buy=7
     * 第4天股价10，发现买亏了，直接用10 - buy(7) + profit(第3天)就是最大收益
     */
    public int maxProfit1(int[] prices, int fee) {
        int n = prices.length, profit = 0;
        int buy = prices[0] + fee;
        for (int i = 1; i < n; i++) {
            int price = prices[i];
            if (price + fee < buy) {
                buy = price + fee;
            } else if (price > buy) {
                profit += price - buy;
                // 以防反悔今天卖出
                buy = price;
            }
        }
        return profit;
    }
}
