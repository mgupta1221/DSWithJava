package PepLevelUp.DP;

import java.util.HashMap;

// LC 1137
public class Tribonacci {
    private static int GetTribonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        return GetTribonacci(n - 1) + GetTribonacci(n - 2) + GetTribonacci(n - 3);

    }

    // Memoization method - Bottom Up
    private static int GetTribonacci_Memo(int n, int[] dp) {
        if (n == 0 || n == 1) {
            dp[n] = n;
            return dp[n];
        }
        if (n == 2) {
            dp[n] = 1;
            return dp[n];
        }
        if (dp[n - 1] == 0) {
            dp[n - 1] = GetTribonacci_Memo(n - 1, dp);
        }
        if (dp[n - 2] == 0) {
            dp[n - 2] = GetTribonacci_Memo(n - 2, dp);
        }
        if (dp[n - 3] == 0) {
            dp[n - 3] = GetTribonacci_Memo(n - 3, dp);
        }
        return dp[n - 1] + dp[n - 2] + dp[n - 3];

    }

    // Tabulation method - Top Down
    private static int GetTribonacci_Tab(int N) {
        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[N];

    }

    // Tabulation method- Optimisez - Top Down
    // 0 1 1 2 3 5 8
    // a b sum
    // We create 2 variables a and b, keep moving a and b's position so we do not
    // need entire dp array as earlier
    // as we only need last 2 computations to calculate current value.

    private static int GetTribonacci_Tab_Opti(int N) {
        int a = 0, b = 1, c = 1;
        int sum = 0;
        for (int n = 0; n < N; n++) {
            sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }
        return a;

    }

    public static void main(String[] args) {

        // Recursive logic
        // 0 1 1 2 3 5 8 13
        // int result = GetTribonacci(4);
        // System.out.println(result);

        // Memoization - ( DP Approach 1 Top Down) Recursion and Caching
        // int num = 4;
        // int[] dp = new int[num + 1];
        // int result = GetTribonacci_Memo(num, dp);
        // System.out.println(result);

        // Tabulation (DP Approach 2 Bottom up) Iterative(loop) WITHOUT Recursion
        // int num = 4;
        // int result = GetTribonacci_Tab(num);
        // System.out.println(result);

        // Tabulation - Optimized
        int num = 10;
        int result = GetTribonacci_Tab_Opti(num);
        System.out.println(result);

    }

}
