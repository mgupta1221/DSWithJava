package PepLevelUp.DP;

import java.util.HashMap;

public class Fibonacci {

    private static int GetFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return GetFibonacci(n - 1) + GetFibonacci(n - 2);
    }

    // Memoization method - Bottom Up
    private static int GetFibonacci_Memo(int n, int[] dp) {
        if (n == 0 || n == 1) {
            dp[n] = n;
            return n;
        }
        // only calculate if no value is present in dp array
        if (dp[n - 1] == 0) {
            dp[n - 1] = GetFibonacci_Memo(n - 1, dp);
        }
        if (dp[n - 2] == 0) {
            dp[n - 2] = GetFibonacci_Memo(n - 2, dp);
        }
        return dp[n - 1] + dp[n - 2];
    }


    // Tabulation method - Top Down
    private static int GetFibonacci_Tab(int N) {

        int[] dp = new int[N + 1];

        for (int n = 0; n <= N; n++) {
            if (n == 0 || n == 1) {
                dp[n] = n;
                continue;
            }
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[N];

    }

    // Tabulation method- Optimisez - Top Down
    // 0 1 1 2 3 5 8
    // a b sum
    // We create 2 variables a and b, keep moving a and b's position so we do not
    // need entire dp array as earlier
    // as we only need last 2 computations to calculate current value.

    private static int GetFibonacci_Tab_Opti(int N) {

        int a = 0, b = 1;
        int sum = 0;
        for (int n = 0; n < N; n++) {
            sum = a + b;
            a = b;
            b = sum;

        }
        return a;

    }

    public static void main(String[] args) {

        // Recursive logic
        // 0 1 1 2 3 5 8 13
        // int result = GetFibonacci(5);

        // // Memoization
        // int num = 10;
        // int[] dp = new int[num + 1];
        // int result = GetFibonacci_Memo(num, dp);
        // System.out.println(result);

        // Tabulation
        // int num = 10;        
        // int result = GetFibonacci_Tab(num);
        // System.out.println(result);

        // Tabulation - Optimized
        int num = 10;
        int result = GetFibonacci_Tab_Opti(num);
        System.out.println(result);

    }

}
