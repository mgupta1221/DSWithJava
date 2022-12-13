package StriverSheet.Day15_Strings;

// Problem: LC : 5 https://leetcode.com/problems/longest-palindromic-substring/

// Solution explanation:
// https://www.youtube.com/watch?v=UflHuQj6MVA

// Cell [i,j] represent if string formed from index i to j is pallendrome or
// not.
// If pallendrome than will store 1

// We have to fill the upper half of the 2D DP array from top left to bottom
// right hence notice the loop - middle lognest diagnal first then upper
// diagonal than its upper diagnal like that

// The last dp cell with value 1 will be the lenghthiest one and will be
// returned  as answer
public class LongestPallendromeInString {

    public static String longestPalindrome(String str) {

        String ans = "";
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < str.length(); i++, j++) { // Notice the 2 loops , we have to fill upper triangle
                                                                 // of 2-D array in a diagnal way..see video

                // main diagnal of the 2D array will represent 1 charcter hence will be
                // pallendrome
                if (i == j) {
                    dp[i][j] = 1;
                }
                // diagonal just uppoer to main diagnal will be 2 character long
                // and if both chracters are same they will be pallendome
                else if (i + 1 == j) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 1;
                    }
                }
                // for other cases- if left most and right most character is same than
                // move 1 charcter from left and 1 chacter from right and checkF if they are
                // pallendrome
                // (checking if the value is 1)
                else {

                    int x1 = str.charAt(i);
                    int x2 = str.charAt(j);
                    if (x1 == x2 && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }

                }

                // keep setting the latest value...the last value will be the answer
                if (dp[i][j] == 1) {
                    ans = str.substring(i, j + 1);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abbccbe";
       // str = "abba";

        String result = longestPalindrome(str);
        System.out.println(result);

    }

}
