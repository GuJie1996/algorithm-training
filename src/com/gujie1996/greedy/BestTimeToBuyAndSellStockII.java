package com.gujie1996.greedy;

public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] prices = new int[] { 7,1,5,3,6,4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int prePrice = prices[0];
        int maxProfit = 0;
        for (int index = 1; index < prices.length; index++) {
            int curPrice = prices[index];
            if (curPrice > prePrice) {
                maxProfit += curPrice - prePrice;
            }
            prePrice = curPrice;
        }
        return maxProfit;
    }

}
