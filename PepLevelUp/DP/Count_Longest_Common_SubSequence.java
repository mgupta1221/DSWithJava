package PepLevelUp.DP;

///LC 1143
// For Logic:  https://www.youtube.com/watch?v=0Ql40Llp09E
// See first half , dont see 2D wala part in video

/// For Solution code: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

// Trick diagram : "Count_LongestCommonSubseq.png"
// Recursive solution
public class Count_Longest_Common_SubSequence {
    public static int count_Longest_Common_Subsequence(String str1, String str2, int s1j,
            int s2j) {
        // If any or both of the strings are of 0 length- than no LCS was found
        if (s1j == 0 || s2j == 0) {
            return 0;
        }
        // Find last charcters of both strings and compare, (remember in Longest
        // Palendromic question we
        // compared first and last chacrerters both of the given string)
        char lastCharOfStr1 = str1.charAt(s1j - 1);
        char lastCharOfStr2 = str2.charAt(s2j - 1);

        // If last chacrters of both are same than answer will be in subset of string
        // witout last charcter
        // E.g. strings are "AGTB" and "ATB" than answer will be in "AGT" and "AT"
        // Else if String are "AGTD" and "ATB" than answer will with be one of the
        // following: "
        // 1) "AGT" and "ATB" (removing last chacrter from first string)
        // 2) "AGTD" and "AT" (removing last chacrter from second string)
        // See trick diagram
        if (lastCharOfStr1 == lastCharOfStr2) {
            return 1 + count_Longest_Common_Subsequence(str1, str2, s1j - 1, s2j - 1); // adding 1 notice for last
                                                                                       // chacrter which matched in both
                                                                                       // strings
        }
        int x = count_Longest_Common_Subsequence(str1, str2, s1j, s2j - 1);
        int y = count_Longest_Common_Subsequence(str1, str2, s1j - 1, s2j);
        return Math.max(x, y);

    }

    // Memoized solution with above recusrive solution only
    public static int count_Longest_Common_Subsequence_MemoisedwithDP(String str1, String str2, int s1j,
            int s2j, int[][] dp) {

        if (s1j == 0 || s2j == 0) {
            return dp[s1j][s2j] = 0;
        }

        char lastCharOfStr1 = str1.charAt(s1j - 1);
        char lastCharOfStr2 = str2.charAt(s2j - 1);

        if (lastCharOfStr1 == lastCharOfStr2) {
            dp[s1j][s2j] = 1 + count_Longest_Common_Subsequence(str1, str2, s1j - 1, s2j - 1);
        }
        // checking if value already exists than return hence saving calls
        // IMPORTANT Note: if you place this above before the if statement above, it
        // will not
        // work, So you
        // have to place it here
        if (dp[s1j][s2j] != 0) {
            return dp[s1j][s2j];
        }
        int x = count_Longest_Common_Subsequence(str1, str2, s1j, s2j - 1);
        int y = count_Longest_Common_Subsequence(str1, str2, s1j - 1, s2j);
        return dp[s1j][s2j] = Math.max(x, y);

    }

    public static void main(String[] args) {
        String str1 = "GeeksForGeekQuiz"; // rember elements need to be in continious for SubSequence
        String str2 = "GeeksQuiz";
        // int result = count_Longest_Common_Subsequence(str1, str2, str1.length(),
        // str2.length());

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int result = count_Longest_Common_Subsequence_MemoisedwithDP(str1, str2,
                str1.length(), str2.length(), dp);
        System.out.println(result);
    }
}
