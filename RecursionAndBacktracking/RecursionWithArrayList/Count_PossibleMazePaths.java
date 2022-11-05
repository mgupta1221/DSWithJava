package RecursionAndBacktracking.RecursionWithArrayList;

import java.util.ArrayList;

public class Count_PossibleMazePaths {

    // Approach 1: This is recursive approach but will cause TLE on Leetcode TC: 2^n (Exponential)
    // Approach 2: This is DP approach approach but will NOT cause TLE on Leetcode TC: m*n
    
    // https://leetcode.com/problems/unique-paths/discuss/2370251/Java-oror-Recursion-oror-DP-oror-Combinations 
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int count = getMazePaths_approach1(0, 0, m, n);
        // int count = getMazePaths_approach2( m, n);
        System.out.println(count);

    }

    // Approach 1: This is recursive approach but will cause TLE on Leetcode
    public static int getMazePaths_approach1(int sr, int sc, int dr, int dc) {
        if (sr == dr || sc == dc) {
            return 0;
        }
        if (sr == dr - 1 && sc == dc - 1) {
            return 1;
        }
        return getMazePaths_approach1(sr + 1, sc, dr, dc) + getMazePaths_approach1(sr, sc + 1, dr, dc);
    }

    // Approach 2: This is DP approach approach but will NOT cause TLE on Leetcode
    public static int getMazePaths_approach2(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
