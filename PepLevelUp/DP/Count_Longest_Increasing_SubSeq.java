package PepLevelUp.DP;

public class Count_Longest_Increasing_SubSeq {

    // Leetcode Problem 300 - Part of Blind75
    // Solution video - DP solution
    // https://www.youtube.com/watch?v=DxhfziFFJNc
    private static int count_Longest_Increasing_SubSeq_tabulation(int[] arr, int idx, int[] dp) {

        // 1 character ka LIS 1 to hoga hi
        dp[0] = 1;

        // variable to maintian longest subsequence so far
        int maxlength = 0;
        // go from left to right
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1; // itna to hoga hi
            // go from 0 to ith index- check if number at jth index < ith , then only update
            // add dp[j]+1 into dp[i]

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    // keep updating dp[i] with dp[j]+1 till you keep getting higher value in dp
                    // while iterating from 0th to ith index
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            // once dp[i] is calculated, change 'maxlength' to highest dp[i] so that we
            // maintain longest subsequence
            if (dp[i] > maxlength) {
                maxlength = dp[i];
            }
        }

        return maxlength;

    }

    public static void main(String[] args) {
        int[] arr = { 3, 10, 2, 1, 20 };

        int[] dp = new int[arr.length];
        int result = count_Longest_Increasing_SubSeq_tabulation(arr, 0, dp);
        System.out.println(result);
    }
}
