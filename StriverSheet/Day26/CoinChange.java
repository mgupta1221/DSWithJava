package StriverSheet.Day26;

import java.util.ArrayList;
import java.util.List;

// Problem: LC 322 https://leetcode.com/problems/coin-change/
// Problem Description: the fewest number of coins that you need to make up that amount. 
// If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

public class CoinChange {

    public static int coinChange(int[] coins, int target) {
        List<Integer> resultingCoins = new ArrayList<>();
        coinChange_helper(coins, coins.length - 1, target, resultingCoins, 0);
        return resultingCoins.size();

    }

    public static void coinChange_helper(int[] coins, int idx, int target, List<Integer> resultingCoins,
            int coinCount) {
        if (idx == -1) {
            if (target == 0) {
                return;
            } else {
                resultingCoins.clear();
                return;
            }
        }
        if (target >= coins[idx]) {
            resultingCoins.add(coins[idx]);
            coinChange_helper(coins, idx, target - coins[idx], resultingCoins, coinCount + 1);
        } else {
            coinChange_helper(coins, idx - 1, target, resultingCoins, coinCount);
        }

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount)); // 3
    }

}
