package PepLevelUp.DP;

// LC 70
// Solved using Recursive approach
public class ClimbStairs {

    // n is total steps in a staircase, we have to find distinct ways to climb to
    // the top with either 1 or 2 step at a time
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return climbStairsHelper(n, dp);
    }

    // recursive helper function - Problem solved using Recusrion and Memoizaton
    public static int climbStairsHelper(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        int a = climbStairsHelper(n - 1, dp);
        int b = climbStairsHelper(n - 2, dp);

        dp[n] = a + b;
        return dp[n];
    }

    public static void main(String[] args) {

        int result = climbStairs(3);
        System.out.println(result);
    }
}
