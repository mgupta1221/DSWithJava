package StriverSheet.Day8_Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Problem: https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
// Approach : https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java

// Approach 1: Top down Dynamic programming using Hashmap for DP values
// Approach 2: Top down Dynamic programming using 2D array fr DP values
// Approach 2: Plain recursive approach but with exponential time complexity and space complexity is way greater than O(n).
public class MinCoinsToMakeTargetSum {

    public static int minCoins_approach1(int[] coins, int n, int target) {
        Map<Integer, Integer> dpMap = new HashMap<>();

        int result = minCoins_approach1_helper(coins, n, target, dpMap);
        return result;
    }

    public static int minCoins_approach1_helper(int[] coins, int n, int target, Map<Integer, Integer> dpMap) {

        if (target == 0)
            return 0;

        if (dpMap.containsKey(target)) {
            return dpMap.get(target);
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                int tempResult = minCoins_approach1_helper(coins, n, target - coins[i], dpMap);

                // Note that "tempResult" is checked for MaxValue, not "result" and +1 is done
                // to add 1 counter for that coin which is considered in this loop
                if (tempResult != Integer.MAX_VALUE && tempResult + 1 < result) {
                    result = tempResult + 1;
                }
            }
        }
        // if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to
        // it.

        dpMap.put(target, result);
        return result;

    }

    public static int minCoins_approach2(int[] coins, int n, int target, int[][] dp) {

        if (target == 0) {
            return 0;
        }

        if (dp[n][target] != 0) {
            return dp[n][target];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                int count = minCoins_approach2(coins, n, target - coins[i], dp);
                if (count != Integer.MAX_VALUE && count + 1 < minCoins) {
                    minCoins = count + 1;
                }
            }
        }

        dp[n][target] = minCoins;
        return dp[n][target];
    }

    // Appraoch 3:
    public static int minCoins_approach3(int[] coins, int n, int target) {

        // If V == 0, then 0 coins required.
        if (target == 0)
            return 0;

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (target - coins[i] >= 0) {
                int tempResult = minCoins_approach3(coins, n, target - coins[i]);

                if (tempResult != Integer.MAX_VALUE && tempResult + 1 < result) {
                    result = tempResult + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int coins[] = { 9, 6, 5, 1 };
        int m = coins.length;
        int target = 11;

        // int coins[] = { 9, 2, 11, 5, 14, 17, 8, 18 };
        // int m = coins.length;
        // int V = 39;

        // Approach 1:
        // System.out.println("Minimum coins required is " + minCoins_approach1(coins,
        // m, target));

        // Approach 2:
        int[][] dp = new int[coins.length][target + 1];
        System.out.println("Minimum coins required is " + minCoins_approach2(coins, coins.length - 1, target, dp));

        // Appaorch 3:
        // System.out.println("Minimum coins required is " + minCoins_approach3(coins,
        // m, target));
    }
}
