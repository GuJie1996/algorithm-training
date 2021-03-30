package com.gujie1996.dp;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[] { 186,419,83,408 };
        System.out.println(new CoinChange().coinChange(coins, 6249));
    }
    public int coinChange(int[] coins, int amount) {
        // 5 5 1
        // 2 5 2 2
        // 5 2 2 2
        // 金额n所需的最少硬币个数
        // 重复子结构是金额少的
        if (amount == 0) {
            return 0;
        }
        int[] minCoins = new int[amount];
        int minCoin = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) {
                continue;
            }
            minCoins[coin-1] = 1;
            minCoin = Math.min(minCoin, coin);
        }
        if (minCoin == Integer.MAX_VALUE) {
            return -1;
        }
        for (int i = minCoin-1; i < amount; i++) {
            if (minCoins[i] == 0) {
                // 没有初值，说明可以参加计算
                minCoins[i] = Integer.MAX_VALUE;
            }
            for (int coin : coins) {
                if (i < coin || minCoins[i-coin] == 0 || minCoins[i-coin] == Integer.MAX_VALUE) {
                    // 不可能的情况，直接跳过
                    continue;
                }
                minCoins[i] = Math.min(minCoins[i], minCoins[i-coin] + 1);
            }
        }
        return minCoins[amount-1] == Integer.MAX_VALUE ? -1 : minCoins[amount-1];
    }
}
