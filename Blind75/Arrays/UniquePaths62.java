package Blind75.Arrays;

public class UniquePaths62 {

    // LC: 62 https://leetcode.com/problems/unique-paths/

    public static int uniquePaths_recursion(int m, int n, int r, int c, int[][] directions, String[] dirNames) {

        if (r == m || c == n)
            return 1;

        int count = 0;
        for (int i = 0; i < dirNames.length; i++) {
            int r1 = r + directions[i][0];
            int c1 = c + directions[i][1];
            if (r1 >= 0 && r1 <= m && c1 >= 0 && c1 <= n)
                count += uniquePaths_recursion(m, n, r1, c1, directions, dirNames);
        }
        return count;
    }

    public static int uniquePaths_dp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {// only 1 path possible from cells of first row and first colmn
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // int[][] directions = { { 0, 1 }, { 1, 0 } };
        // String[] dirNames = { "right", "down" };
        int m = 3;
        int n = 7;
        // int totalPaths = uniquePaths_recursion(m - 1, n - 1, 0, 0, directions,
        // dirNames);

        int totalPaths = uniquePathsHelper(m, n, 0, 0);

        System.out.println(totalPaths);
    }

    public static int uniquePathsHelper(int m, int n, int r, int c) {
        if (r > m - 1 || c > n - 1)
            return 0;

        if (m - 1 == r && n - 1 == c) {
            return 1;
        }

        int count = 0;
        while (r < m && c < n) {
            count += uniquePathsHelper(m, n, r + 1, c) +
                    uniquePathsHelper(m, n, r, c + 1);
        }
        return count;
    }

}
