package StriverSheet.Day8_Greedy;

public class ZeroOneKnapsack {

    // Problem: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

    // Solution 1: Bruteforce Solution below
    // static int knapSack_bruteForce(int W, int wt[], int val[], int n) {
    // int maxValue = Integer.MIN_VALUE;
    // int sumOfWeight = 0;
    // int sumOfVal = 0;
    // for (int i = 0; i < val.length; i++) {
    // sumOfWeight = wt[i];
    // for (int j = i + 1; j < val.length; j++) {
    // if (sumOfWeight + wt[j] <= W) {
    // sumOfWeight = sumOfWeight + wt[j];
    // sumOfVal = sumOfVal + val[j];
    // maxValue = Math.max(sumOfVal, maxValue);
    // }
    // }
    // }
    // return maxValue;
    // }

    // Solution 2: Recursive solution
    // Time Complexity: It should be noted that the above function computes the same
    // sub-problems
    // again and again. The time complexity of this naive recursive solution is
    // exponential
    // (2^n).

    static int knapSack_recursion(int W, int wt[], int val[], int n) {

        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return knapSack_recursion(W, wt, val, n - 1);

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        // Note that value is added only when
        return Math.max(val[n - 1] + knapSack_recursion(W - wt[n - 1], wt, val, n - 1),
                knapSack_recursion(W, wt, val, n - 1));
    }

    // Solution 3 : Recursion with memoization
    static int knapSack_recursion_With_Memo(int W, int wt[], int val[], int n) {

        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        return knapSack_recursion_With_Memo_helper(W, wt, val, n, dp);
    }

    static int knapSack_recursion_With_Memo_helper(int W, int wt[], int val[], int n, int[][] dp) {
        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W) {
            dp[n][W] = knapSack_recursion_With_Memo_helper(W, wt, val, n - 1, dp);
            return dp[n][W];
        }

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        // Note that value is added only when
        dp[n][W] = Math.max(val[n - 1] + knapSack_recursion_With_Memo_helper(W - wt[n - 1], wt, val, n - 1, dp),
                knapSack_recursion_With_Memo_helper(W, wt, val, n - 1, dp));
        return dp[n][W];
    }

    // Solution 4 : DP solution
    static int knapSack_recursion_DP(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    // jab nahi khelega, to previous wali value aa jayegi
                    int x = dp[i - 1][w];
                    // Khelega, or , value aayegi
                    int y = val[i - 1] + dp[i - 1][w - wt[i - 1]];

                    dp[i][w] = Math.max(x, y);
                } else {
                    // jab nahi khelega, to previous wali value aa jayegi
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];

    }

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        // Bruteforce solution
        // System.out.println(knapSack_bruteForce(W, wt, val, n));

        // Recursive solution
        // System.out.println(knapSack_recursion(W, wt, val, n));

        // Recursive with Memo solution
        // System.out.println(knapSack_recursion_With_Memo(W, wt, val, n));

        // Recursive with DP
        System.out.println(knapSack_recursion_DP(W, wt, val, n));
    }

}
