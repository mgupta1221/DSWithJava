package PepLevelUp.DP;

// LC 583
// Problem:
// https://leetcode.com/problems/delete-operation-for-two-strings/

// Similar to Edit Distance problem, just that we have only delete instead of 3 operations
public class Count_minDeleteToConvert {

    private static int Count_minDeletionToConvert(String str1, String str2, int m, int n, int[][] dp) {

        // If first string is empty, the only option is to
        // delete all characters of the other string
        if (m == 0) {
            return dp[m][n] = n;
        }

        if (n == 0) {
            return dp[m][n] = m;

        }

        // memoization
        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        // get last charcter of first string
        char a = str1.charAt(m - 1);
        char b = str2.charAt(n - 1);

        int x1 = Count_minDeletionToConvert(str1, str2, m - 1, n - 1, dp);
        int x2 = Count_minDeletionToConvert(str1, str2, m, n - 1, dp);
        int x3 = Count_minDeletionToConvert(str1, str2, m - 1, n, dp);

        // if last charcter of both are same than iterate till m-1, n-1, else 1
        // less from each and get minimum
        if (a == b) {
            dp[m][n] = x1;
        } else {
            dp[m][n] = Math.min(x2, x3) + 1; // notice we are taking
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        int result = Count_minDeletionToConvert(word1, word2, word1.length(), word2.length(), dp);
        System.out.println(result);

    }
}
