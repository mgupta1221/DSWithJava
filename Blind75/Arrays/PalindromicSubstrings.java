package Blind75.Arrays;

// Same as LongestPallendromicSubstring.java
// Just instead of returning the longest pallendromic substring, we will keep a count of pallendromic substrings
public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int count = 0;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }

                if (dp[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }
}
