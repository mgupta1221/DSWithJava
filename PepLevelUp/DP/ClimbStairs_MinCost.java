package PepLevelUp.DP;

public class ClimbStairs_MinCost {

    // LC 746

    // Solution explanation:
    // https://www.youtube.com/watch?v=ktmzAZWkEZ0
    // we solved this with ITEARTIVE DP approach(Bottom up)
    // E.g. [10,15 20]
    // We first delcared DP of n+1 length

    // we run the loop from right to left and we initally assigned dp[i]= cost[n-1]
    // and dp[i+1]=0 because for value 'n' we have to check at cell n+2 and
    // n+1(becuase from one cell you can move 1 or 2 steps) and get the minimum so
    // we need values there
    // Then in the loop we find the min of [cost at cell n + dp(n+1)] and [cost at
    // cell n + dp(n+2)] and populate dp array
    // Since it is given we can start from cell 0 or cell 1 to get the minumum, we
    // get the minimum of 2 at the end.
    public static int minCostClimbingStairs_Tabulation(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[cost.length] = 0;
        dp[cost.length - 1] = cost[cost.length - 1];

        for (int i = cost.length - 2; i >= 0; i--) {
            dp[i] = Math.min(cost[i] + dp[i + 1], cost[i] + dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    public static int minCostClimbingStairs_RecursiveDP(int[] cost) {
        int[] dp = new int[cost.length + 1];
        return minCostClimbingStairs_RecursiveDP_Helper(cost, cost.length, dp);
    }

    // recursive helper for recusrive solution
    public static int minCostClimbingStairs_RecursiveDP_Helper(int[] cost, int n, int[] dp) {
        if (n <= 1) {
            dp[n] = cost[n];
            return dp[n];
        }
        // If already calculated, dont calculate again
        if (dp[n] != 0) {
            return dp[n];
        }
        int a = minCostClimbingStairs_RecursiveDP_Helper(cost, n - 1, dp);
        int b = minCostClimbingStairs_RecursiveDP_Helper(cost, n - 2, dp);
        // since loop is runing from 0 to n (not n-1) so last cells cost will be 0
        int currentCost = n == cost.length ? 0 : cost[n];
        dp[n] = Math.min(a + currentCost, b + currentCost);
        return dp[n];
    }

    public static void main(String[] args) {

        int[] costs = new int[] { 10, 15 };
        // int result = minCostClimbingStairs_Tabulation(costs);
        // System.out.println(result);

        int result = minCostClimbingStairs_RecursiveDP(costs);
        System.out.println(result);

    }
}
