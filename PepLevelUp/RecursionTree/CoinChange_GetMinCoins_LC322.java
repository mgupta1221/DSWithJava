
package PepLevelUp.RecursionTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// Problem: LC 322 https://leetcode.com/problems/coin-change/description/
// Approach 1: Recursion

// Approach 2: DP
// Solution video for DP approach : https://www.youtube.com/watch?v=jl68j3vLHZk

// Approach 3: BFS with Queue-  O(ns).  n is number of coins and s is the amount
// The problem asks for fewest coins. It is natrual to think of BFS which guarantess shortest path.

public class CoinChange_GetMinCoins_LC322 {

    // Apparoach 1: Recursion
    public static int coinChange(int[] coins, int target) {
        int result = coinChangeHelper(coins, target, 0);
        if (result != (int) 1e9) {
            return result;
        }
        return -1; // return -1 if minimum could not be found
    }

    // Full explanation given in word doc
    public static int coinChangeHelper(int[] coins, int target, int idx) {
        if (target == 0) {
            return 0;
        }

        // Check image in doc file why we are adding 1 at line 17 below
        int min = (int) 1e9; // use this, instead of Integer.MAX_VALUE
        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                min = Math.min(min, 1 + coinChangeHelper(coins, target - coins[i], i));
            }
        }

        return min;
    }

    // Approach 2: DP
    public static int coinChange_DP(int[] coins, int target) {
        int dp[][] = new int[coins.length + 1][target + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= target; j++) {

                if (j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) { // first row as infinite becuase if we have 0 coins than
                    // to make any target, we
                    // need 'infinite' coins
                    dp[i][j] = Integer.MAX_VALUE - 1;/// subtracting 1 becuase we have to add 1
                    // later so it will not overflow

                } else if (j < coins[i - 1]) { // 'excluding current coin' case
                    dp[i][j] = dp[i - 1][j];
                } else {// including current coin case
                    int x = dp[i - 1][j];
                    int y = 1 + dp[i][j - coins[i - 1]];
                    dp[i][j] = Math.min(x, y); // adding 1
                }
            }
        }
        return dp[coins.length][target] > 10000 ? -1 : dp[coins.length][target]; // becuase in question limit given is
                                                                                 // <= 10000
    }

    // Approach 2: BFS
    public static int coinChange_BFS(int[] coins, int target) {
        Queue<Integer> queue = new ArrayDeque();
        queue.add(0);
        int coinCount = 0;

        Boolean[] visited = new Boolean[target + 1];// tp avoid TLE
        Arrays.fill(visited, false);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentSum = queue.poll();

                if (currentSum == target) {
                    return coinCount;
                }
                if (currentSum > target || visited[currentSum]) {
                    continue;
                }
                visited[currentSum] = true;// to avoid TLE

                for (Integer coin : coins) {
                    queue.add(currentSum + coin);
                }
            }
            coinCount++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int target = 10;
        // var result = coinChange(coins, target); // Approach 1: Recursion

        // int[] coins = { 1};
        // int target = 10000;
        // var result = coinChange_DP(coins, target);// Approach 2: DP

        var result = coinChange_BFS(coins, target);// Approach 3: BFS
        System.out.println(result);
    }
}
