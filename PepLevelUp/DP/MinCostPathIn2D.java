package PepLevelUp.DP;

public class MinCostPathIn2D {
    // leet code 64

    private static int MinCostPath(int[][] twoDArray) {

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

    public static void main(String[] args) {

        int[][] TwoDArray = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        int result = MinCostPath(TwoDArray);
        System.out.println(result);

    }
}
