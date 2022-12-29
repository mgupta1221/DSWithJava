package StriverSheet.Day25_DP;

//The difference between a longest common substring and a longest common subsequence 
//is the criterion of contiguity. The symbols that make up a longest common substring 
// must appear in both strings as a contiguous string.

// Problem: LC 1143 https://leetcode.com/problems/longest-common-subsequence/

// Problem description: A subsequence of a string is a new string generated from the original
// string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".

// Appraoch 1: Recursive  - Will cause TLE
// Appraoch 2: DP with memoization 

public class Longest_Common_Subsequence {

    // Approach 1 - Pure recursive
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        return longestCommonSubs_helper(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    // helper
    public static int longestCommonSubs_helper(String text1, String text2, int idx1, int idx2) {
        if (idx1 == -1 || idx2 == -1)
            return 0;

        char ch1 = text1.charAt(idx1);
        char ch2 = text2.charAt(idx2);

        if (ch1 == ch2) {
            return 1 + longestCommonSubs_helper(text1, text2, idx1 - 1, idx2 - 1);
        }
        return Math.max(longestCommonSubs_helper(text1, text2, idx1, idx2 - 1),
                longestCommonSubs_helper(text1, text2, idx1 - 1, idx2));

    }

    // Appraoch 2: DP with memoization - no TLE
    public static int longestCommonSubsequence_memoizedDP(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length()][text2.length()];
        return longestCommonSubsequence_memoizedDP_helper(text1, text2, text1.length() - 1, text2.length() - 1, dp);

    }

    // DP helper
    public static int longestCommonSubsequence_memoizedDP_helper(String text1, String text2, int idx1, int idx2,
            int[][] dp) {
        if (idx1 == -1 || idx2 == -1) {
            dp[0][0] = 0;
            return 0;
        }

        char ch1 = text1.charAt(idx1);
        char ch2 = text2.charAt(idx2);

        if (ch1 == ch2) {
            dp[idx1][idx2] = 1
                    + longestCommonSubsequence_memoizedDP_helper(text1, text2, idx1 - 1, idx2 - 1, dp);
        }

        if (dp[idx1][idx2] != 0) {
            return dp[idx1][idx2];
        } else {
            int x = longestCommonSubsequence_memoizedDP_helper(text1, text2, idx1, idx2 - 1, dp);
            int y = longestCommonSubsequence_memoizedDP_helper(text1, text2, idx1 - 1, idx2, dp);
            dp[idx1][idx2] = Math.max(x, y);
            return dp[idx1][idx2];
        }

    }

    public static void main(String[] args) {

        // String text1 = "abcde", text2 = "ace"; // ans: 3 "ace"

        String text1 = "bl", text2 = "yby"; // ans: 1 "b"

        int result = longestCommonSubsequence(text1, text2);// Approach 1 : Recursive

        // int result = longestCommonSubsequence_memoizedDP(text1, text2); //Appraoch2:
        // DP with memoization

        System.out.println(result);

    }

}
