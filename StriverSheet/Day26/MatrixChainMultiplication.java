package StriverSheet.Day26;

import java.util.Arrays;

// Problem: https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

// Solution video : https://www.youtube.com/watch?v=kMK148J9qEE

// Pattern for MCM questions to solve other similar pattern questions: https://www.youtube.com/watch?v=D7AFvtnDeMU
public class MatrixChainMultiplication {

    static int matrixMultiplication(int N, int arr[]) {
        int dp[][] = new int[N + 1][arr.length + 1];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return matrixMultiplication_helper(N, arr, 1, arr.length - 1, dp);
    }

    // helper
    static int matrixMultiplication_helper(int N, int arr[], int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = matrixMultiplication_helper(N, arr, i, k, dp);
            int right = matrixMultiplication_helper(N, arr, k + 1, j, dp);
            int current = arr[i - 1] * arr[k] * arr[j];
            int tempAns = left + right + current;
            min = Math.min(min, tempAns);

        }
        dp[i][j] = min;
        return min;
    }

    public static void main(String[] args) {

    }

}
