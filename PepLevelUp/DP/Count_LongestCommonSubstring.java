package PepLevelUp.DP;

import java.util.Arrays;

//The difference between a longest common substring and a longest common subsequence 
//is the criterion of contiguity. The symbols that make up a longest common substring 
// must appear in both strings as a contiguous string.

// Problem
// https://www.geeksforgeeks.org/longest-common-substring-dp-29/

//Solution- With Tabulation approach (Top down) video
//https://www.youtube.com/watch?v=BysNXJHzCEs

// Code link:
// https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestCommonSubstring.java

public class Count_LongestCommonSubstring {

    private static int Count_LongestCommonSubStr(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        int maxResult = 0;

        for (int i = 0; i <= str1.length(); i++) {// Notice we are running loop till length
            // becuase we have to fill dp[i][j] and first row and column of dp are set to 0
            // and characters start after that
            for (int j = 0; j <= str2.length(); j++) {
                // setting first row and first column to 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {

                    char char1 = str1.charAt(i - 1);
                    char char2 = str2.charAt(j - 1);
                    if (char1 == char2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        maxResult = Math.max(maxResult, dp[i][j]);
                    } else {
                        dp[i][j] = 0;
                    }

                }
            }
        }

        return maxResult;
    }

    public static void main(String[] args) {
        String word1 = "GeeksforGeeks", word2 = "GeeksQuiz";

        int result = Count_LongestCommonSubStr(word1, word2);
        System.out.println(result);
    }
}
