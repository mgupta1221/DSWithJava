package StriverSheet.Day8_Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Problem: https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
// Approach : https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java

// Approach 1: Top down Dynamic programming without 2D array
// Approach 2: Bottom up Dynamic programming without 2D array
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
            if (target - coins[i] < 0) {
                continue;
            }
            int tempResult = minCoins_approach1_helper(coins, n, target - coins[i], dpMap);
            if (tempResult < result) {
                result = tempResult;
            }
        }
        // if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to
        // it.
        result = (result == Integer.MAX_VALUE ? result : result + 1);
        dpMap.put(target, result);
        return result;

    }

    public static int minCoins_approach2(int[] coins, int n, int target) {

        int[][] dp = new int[coins.length + 1][target + 1];

        for (int i = 1; i < dp.length - 1; i++) {
            for (int j = 1; j <= target; j++) {

                if (j >= coins[i]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[coins.length][target];

        // int[][] dp = new int[coins.length][target + 1];

        // for (int i = 1; i < dp.length; i++) {

        // for (int j = 1; j <= target; j++) {
        // if (i == 0)
        // dp[i][j] = 0;

        // if (j >= coins[i]) {
        // dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
        // } else {
        // dp[i][j] = dp[i - 1][j];
        // }
        // }
        // }

        // return dp[coins.length - 1][target];

    }

    public static void main(String[] args) {
        // int coins[] = { 9, 6, 5, 1 };
        // int m = coins.length;
        // int V = 11;

        int coins[] = { 9, 2, 11, 5, 14, 17, 8, 18 };
        int m = coins.length;
        int V = 39;

        // Approach 1:
        System.out.println("Minimum coins required is " + minCoins_approach1(coins,
                m, V));

        // Appaorch 2:
        // System.out.println("Minimum coins required is " + minCoins_approach2(coins,
        // m, V));
    }
}
