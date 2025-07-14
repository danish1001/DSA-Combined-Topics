package Array.Medium;

import java.util.Arrays;
//121. Best Time to Buy and Sell Stock https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
//        You are given an array prices where prices[i] is the price of a given stock on the ith day.
//        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//        Example 1:
//
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//        Example 2:
//
//        Input: prices = [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transactions are done and the max profit = 0.
//
//
//        Constraints:
//
//        1 <= prices.length <= 105
//        0 <= prices[i] <= 104
public class BestTimeToBuyAndSellStock {
    public int maxProfit_sol1(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] > buy) {
                profit = Math.max(prices[i] - buy, profit);
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }

    //--------------------------------------------------------------------------------
    // Recursive Memorization DP
    public int maxProfit_sol2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=0; i<n+1; i++) Arrays.fill(dp[i], -1);
        return solve(prices, 0, n-1, 1, dp);
    }
    private int solve(int[] prices, int i, int n, int canBuy, int[][] dp) {
        if(i == n) {
            if(canBuy == 1) return 0;
            return prices[i];
        }
        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        if(canBuy == 1) {
            int buy = -prices[i] + solve(prices, i+1, n, 0, dp);
            int notBuy = solve(prices, i+1, n, 1, dp);
            return dp[i][canBuy] = Math.max(buy, notBuy);
        } else {
            int sell = prices[i];
            int notSell = solve(prices, i+1, n, 0, dp);
            return dp[i][canBuy] = Math.max(sell, notSell);
        }
    }

    //----------------------------------------------------------------------------------
    // Tabulation DP
    public int maxProfit_sol3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n-1][0] = prices[n-1];

        for(int i=n-1; i>=0; i--) {
            for(int canBuy=0; canBuy<2; canBuy++) {
                if(canBuy == 1) {
                    int buy = -prices[i] + dp[i+1][0];
                    int notBuy = dp[i+1][1];
                    dp[i][canBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[i];
                    int notSell = dp[i+1][0];
                    dp[i][canBuy] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][1];
    }
}
