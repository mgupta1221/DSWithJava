package PepLevelUp.DP;

public class Goldmine {

    // Main problem: https://www.geeksforgeeks.org/gold-mine-problem/

    // With slight variation on Leetcode 1219
    private static int Goldmine_Tab(int[][] mat) {

        int[][] dp = new int[mat.length][mat[0].length];

        // We will traverse the given matrix from right to left and top to down

        for (int j = mat[0].length - 1; j >= 0; j--) { // column
            for (int i = 0; i < mat.length; i++) { // row
                if (j == mat[0].length - 1) { // if it is the last column
                    dp[i][j] = mat[i][j];
                } else if (i == 0) { // if it is the first row
                    dp[i][j] = mat[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == mat.length - 1) { // if it is the last row
                    dp[i][j] = mat[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {// all other cases
                    dp[i][j] = mat[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        // Now the first column has values of all traversed paths and we will take
        // the maxiumum value in the first column as the answrr
        int max = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }

    // Recursive solution
    // Solution video: https://www.youtube.com/watch?v=p5IAkpSs5xU
    private static int Goldmine_recursive(int[][] mat, int sr, int sc, int er, int ec, int[][] dp) {
        if (sr < 0 || sr > mat.length - 1 || sc > mat.length - 1) {
            return 0;
        }
        // moving diagonally right
        int resultLeftDiagonal = Goldmine_recursive(mat, sr - 1, sc + 1, er, ec, dp);
        // moving right
        int resultRight = Goldmine_recursive(mat, sr, sc + 1, er, ec, dp);
        // moving diagonally left
        int resultRightDiagonal = Goldmine_recursive(mat, sr + 1, sc + 1, er, ec, dp);

        return mat[sr][sc] + Math.max(resultLeftDiagonal, Math.max(resultRight, resultRightDiagonal));
    }

    static int getMaxGold(int[][] mat, int m, int n) {
        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        // We are starting from all cells of first column and will move right in
        // recursive call
        for (int i = 0; i < n; i++) {
            // for ith row
            int result = Goldmine_recursive(mat, i, 0, mat[0].length - 1, 0, dp);
            max = Math.max(max, result);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 3, 1, 5 },
                { 2, 2, 4, 1 },
                { 5, 0, 2, 3 },
                { 0, 6, 1, 2 } };

        // via Tabulation
        // int result = Goldmine_Tab(mat);
        // System.out.println(result);

        // int result2 = getMaxGold2(mat, mat.length, mat[0].length);
        // System.out.println(result2);

        // recursive solution
        int result = getMaxGold(mat, mat.length, mat[0].length);
        System.out.println(result);

    }

}
