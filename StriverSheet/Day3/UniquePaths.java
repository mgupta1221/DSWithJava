package StriverSheet.Day3;

public class UniquePaths {

    // LC: 62 https://leetcode.com/problems/unique-paths/

    // Problem: There is a robot on an m x n grid. Return the number of possible
    // unique paths that the robot can take to reach the bottom-right corner.

    // 3 Approaches: This question is solved using both DP (2 ways) and Recursion(1
    // way). See separate functions below

    // In case of DP: First row and First column will be 1 because there is only one
    // way to reach those cells

    // Approach details: https://www.youtube.com/watch?v=rBAxUTqvlQA

    public static int uniquePaths(int m, int n) {

        // Solved using recursion -- Aapproach 1
        // return uniquePaths_recursion(m, n, 0, 0, 0);

        // Solved using recursion -- Approach 2
        // int[][] directions = { { 0, 1 }, { 1, 0 } };
        // String[] dirNames = { "r", "d" };
        // return uniquePaths2(m - 1, n - 1, 0, 0, directions, dirNames);

        // Solved using DP - 2 ways (TOP Down)
        // return uniquePaths_DP1(m, n, 0, 0, 0);
        int[][] dp = new int[m][n];
        return uniquePaths_DP2(0, 0, m, n, dp);
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

    public static int uniquePaths2(int m, int n, int r, int c, int[][] directions, String[] dirNames) {

        if (r == m && c == n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < dirNames.length; i++) {

            int r1 = r + directions[i][0]; // Notice we have to create new variables here and pass it to the recursive
                                           // function
            int c1 = c + directions[i][1];

            if (r1 >= 0 && c1 >= 0 && r1 <= m && c1 <= n) {
                count += uniquePaths2(m, n, r1, c1, directions, dirNames);
            }
        }

        return count;

    }

    public static int uniquePaths_DP1(int m, int n, int currentI, int currentJ, int totalPaths) {

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

    public static int uniquePaths_DP2(int startx, int starty, int endx, int endy, int[][] dp) {
        if (startx >= endx || starty >= endy) {
            return 0;
        }
        if (startx == endx - 1 && starty == endy - 1) {
            return dp[startx][starty] = 1;
        }
        if (dp[startx][starty] != 0) {
            return dp[startx][starty];
        }
        return dp[startx][starty] = uniquePaths_DP2(startx + 1, starty, endx, endy, dp) +
                uniquePaths_DP2(startx, starty + 1, endx, endy, dp);

    }

    public static void main(String[] args) {
        int totalPaths = uniquePaths(3, 7);

        System.out.println(totalPaths);
    }

}
