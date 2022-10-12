package StriverSheet.Day3;

public class UniquePaths {

    // LC: 62 https://leetcode.com/problems/unique-paths/

    // Problem: There is a robot on an m x n grid. Return the number of possible
    // unique paths that the robot can take to reach the bottom-right corner.

    // Approach: This question is solved using both DP and Recursion. See separate
    // functions below

    // In case of DP: First row and First column will be 1 becuase there is only one
    // way to reach those cells

    // Approach details: https://www.youtube.com/watch?v=rBAxUTqvlQA

    public static int uniquePaths(int m, int n) {

        // Solved using recursion
        // return uniquePaths_recursion(m, n, 0, 0, 0);

        // Solved using DP (TOP Down)
        return uniquePaths_DP(m, n, 0, 0, 0);
    }

    public static int uniquePaths_recursion(int m, int n, int currentI, int currentJ, int totalPaths) {
        if (currentI >= m || currentJ >= n) {
            return 0;
        }
        if (currentI == m - 1 && currentJ == n - 1) {
            return 1;
        }

        if (currentI < m && currentJ < n)
            totalPaths = uniquePaths_recursion(m, n, currentI + 1, currentJ, totalPaths + 1) +
                    uniquePaths_recursion(m, n, currentI, currentJ + 1, totalPaths + 1);

        return totalPaths;

    }

    public static int uniquePaths_DP(int m, int n, int currentI, int currentJ, int totalPaths) {

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

    public static void main(String[] args) {
        int totalPaths = uniquePaths(3, 7);

        System.out.println(totalPaths);
    }

}
