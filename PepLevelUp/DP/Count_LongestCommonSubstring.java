package PepLevelUp.DP;

import java.util.Arrays;


// LC: 

//The difference between a longest common substring and a longest common subsequence 
//is the criterion of contiguity. The symbols that make up a longest common substring 
//must appear in both strings as a contiguous string.

// Problem
// https://www.geeksforgeeks.org/longest-common-substring-dp-29/

public class Count_LongestCommonSubstring {

    private static int Count_LongestCommonSubStr(String str1, String str2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return dp[m][n] = 0;
        }

        char char1 = str1.charAt(m - 1);
        char char2 = str2.charAt(n - 1);

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int x1 = Count_LongestCommonSubStr(str1, str2, m - 1, n - 1, dp);
        int x2 = Count_LongestCommonSubStr(str1, str2, m, n - 1, dp);
        int x3 = Count_LongestCommonSubStr(str1, str2, m - 1, n, dp);

        if (char1 == char2) {
            dp[m][n] = 1 + x1;
        } else {
            dp[m][n] = Math.max(x2, x3);
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "GeeksforGeeks", word2 = "GeeksQuiz";
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = Count_LongestCommonSubStr(word1, word2, word1.length(), word2.length(), dp);
        System.out.println(result);
    }
}
