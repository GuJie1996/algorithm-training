package com.gujie1996.dp;

public class BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        int[] prices = new int[] { 1,2,4,7 };
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, prices));
    }
    public int maxProfit(int k, int[] prices) {
        // 第i天(0~i-1)，买卖k次(0~k)以买一次计数, 是否持仓(0~1)
        int length = prices.length;
        if (length < 1 || k < 1) {
            return 0;
        }
        int[][][] dp = new int[length][k+1][2];
        // 初始状态，只要考虑有值的，其他int默认0
        dp[0][1][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            // 初始状态
            dp[i][1][1] = -prices[i];
            for (int ik = 1; ik <= Math.min(i+1, k); ik++) {
                // 状态转移
                dp[i][ik][0] = Math.max(dp[i-1][ik][0], dp[i-1][ik][1] + prices[i]);
                dp[i][ik][1] = Math.max(dp[i-1][ik][1], dp[i-1][ik-1][0] - prices[i]);
                // dp[1][2][0] = dp[0][2][0],dp[0][2][1]+prices[i]会引起虚高
                // dp[1][2][0] 不应该存在，截止第二天买了两次不可能不持仓，即ik > i的话，不持仓的情况赋为0
                if (ik > (i+1)/2) {
                    // 不考虑当天买卖的情况（没有收益）,i+1天至多买卖i+1/2次，即k<=i+1/2
                    // 不可能的情况都置为0
                    dp[i][ik][0] = 0;
                    dp[i][ik][1] = 0;
                    // 第3天买卖了2次，并且持仓
                    // 正好少一天，可以是买入，正常计算，不置0，但是必定持仓，必须扣
                    if (ik == (i+2)/2) {
                        dp[i][ik][1] = dp[i-1][ik-1][0] - prices[i];
                    }
                }
            }
        }
        // 记录最大收益
        int maxProfit = 0;
        // 可能存在length<k，这样k就没意义
        for (int ik = 0; ik <= Math.min(length, k); ik++) {
            maxProfit = Math.max(dp[length-1][ik][0], maxProfit);
        }
        return maxProfit;
    }
}
