package Blind75.Arrays;

// Problem: LC : 5 https://leetcode.com/problems/longest-palindromic-substring/

// Solution explanation:
// https://www.youtube.com/watch?v=UflHuQj6MVA

//For code explanation
//https://www.youtube.com/watch?v=XmSOWnL6T_I

// Cell [i,j] represent if string formed from index i to j is pallendrome or
// not.
// If pallendrome than will store 1

// We have to fill the upper half of the 2D DP array from top left to bottom
// right hence notice the loop - middle lognest diagnal first then upper
// diagonal than its upper diagnal like that

// The last dp cell with value 1 will be the lenghthiest one and will be
// returned  as answer

// here gap = 0 represents main diagnal of matrix, 
// gap=1 represents diagnal just above main diagnal
// For main dialogal, string will always be pallendrome
// For diagnal just above main diagnal, if both characters are same, then it will be pallendrome
// For other diagnals, if left most and right most characters are same, then 
// check if the string formed by removing leftmost and rightmost characters is pallendrome or not

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String ans = "";
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }

                else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                    }
                } else {
                    int x1 = s.charAt(i);
                    int x2 = s.charAt(j);
                    if (x1 == x2 && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }

                if (dp[i][j] == 1) {
                    ans = s.substring(i, j + 1);
                }

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println(lps.longestPalindrome(s));
    }
}
