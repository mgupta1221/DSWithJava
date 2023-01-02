package StriverSheet.Day26;

public class MinPathSum_In_Matrix {

    // Problem LC 64: https://leetcode.com/problems/minimum-path-sum/

    public static int minPathSum(int[][] twoDArray) {
        int dp[][] = new int[twoDArray.length + 1][twoDArray[0].length + 1];

        for (int i = twoDArray.length - 1; i >= 0; i--) {
            for (int j = twoDArray[0].length - 1; j >= 0; j--) {
                if (i == twoDArray.length - 1 && j == twoDArray[0].length - 1) {
                    dp[i][j] = twoDArray[i][j];
                } else if (i == twoDArray.length - 1 && j >= 0) {
                    dp[i][j] = twoDArray[i][j] + dp[i][j + 1];
                } else if (j == twoDArray[0].length - 1 && i >= 0) {
                    dp[i][j] = twoDArray[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = twoDArray[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }; // output 7

        int result = minPathSum(grid);
        System.out.println(result);

    }

}
