package PepLevelUp.DP;

public class MinCostPathIn2D {
    // leet code 64
    // Tabulation solution
    private static int MinCostPath_tab(int[][] twoDArray) {

        int[][] dp = new int[twoDArray.length][twoDArray[0].length];
        for (int i = twoDArray.length - 1; i >= 0; i--) {
            for (int j = twoDArray[0].length - 1; j >= 0; j--) {
                if (i == twoDArray.length - 1 && j == twoDArray[0].length - 1) {
                    dp[i][j] = twoDArray[i][j];
                } else if (i == twoDArray.length - 1) {
                    dp[i][j] = dp[i][j + 1] + twoDArray[i][j];
                } else if (j == twoDArray[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + twoDArray[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + twoDArray[i][j],
                            dp[i][j + 1] + twoDArray[i][j]);
                }
            }
        }
        return dp[0][0];
    }

    // Recursive solution
    public static int minPathSum_recursion(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return minPathSum_recursion_helper(grid, 0, 0, dp);
    }

    public static int minPathSum_recursion_helper(int[][] grid, int i, int j, int[][] dp) {
        if (i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];

        if (dp[i][j] != 0) // path already calculated
            return dp[i][j];

        // store min path at index i, j
        dp[i][j] = Math.min(minPathSum_recursion_helper(grid, i + 1, j, dp),
                minPathSum_recursion_helper(grid, i, j + 1, dp)) + grid[i][j];
        return dp[i][j];
    }

    public static void main(String[] args) {

        int[][] TwoDArray = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        // int result = MinCostPath_tab(TwoDArray);
        // System.out.println(result);

        // Recursive solution call
        System.out.println(minPathSum_recursion(TwoDArray));

    }
}
