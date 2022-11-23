package StriverSheet.Day8_Greedy;

import java.io.Console;
import java.util.Arrays;
import GettingStartedBasics.Stack.MergeIntervals.Pair;

public class Test {

    public static int minCoins_approach1(int[] coins, int n, int target) {
        int[][] dp = new int[coins.length][target + 1];
        int count = minCoins_approach1_helper(coins, n, target, dp);
        System.out.println(count);
        return count;
    }

    public static int minCoins_approach1_helper(int[] coins, int n, int target, int[][] dp) {

        if (target == 0) {
            return 0;
        }

        if (dp[n][target] != 0) {
            return dp[n][target];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                int count = minCoins_approach1_helper(coins, n, target - coins[i], dp);
                if (count != Integer.MAX_VALUE && count + 1 < minCoins) {
                    minCoins = count + 1;
                }
            }
        }

        dp[n][target] = minCoins;
        return dp[n][target];
    }

    public static void main(String[] args) {
        int coins[] = { 9, 6, 5, 1 };
        int m = coins.length - 1;
        int V = 11;

        // Approach 1:
        System.out.println("Minimum coins required is " + minCoins_approach1(coins,
                m, V));

    }
}
