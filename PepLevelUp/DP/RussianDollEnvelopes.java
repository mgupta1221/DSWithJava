package PepLevelUp.DP;

import java.util.Arrays;

// LC 354
// This quesiton is application of Longest Increasing SubSequence

public class RussianDollEnvelopes {

    // O(n^2) hence TLE is coming on Leetcode
    private static int getRussianDollEnvelopes(int[][] envelopes) {
        // Sorting the array [x,y] on x
        // Notice the way to sort with function
        // Notice the arrow is -> (single dash) (NOT =>)
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);

        int N = envelopes.length;

        // implementing LIS now on second element of each item to get the count
        int[] dp = new int[N];
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[][] envelopes = { { 5, 4 }, { 6, 9 }, { 6, 7 }, { 2, 3 } };
        // int[][] envelopes = { { 4, 5 }, { 4, 6 }, { 6, 7 }, { 2, 3 }, { 1, 1 } };
        int result = getRussianDollEnvelopes(envelopes);
        System.out.println(result);

    }
}
