package PepLevelUp.DP;

import java.util.Arrays;

// LC 115
// Similar to minelete to Covert
// Logic in comments and in video of 6th MAy, 1st question 

public class Count_DistinctSubsequences {
    private static int Count_DistinctSub(String str1, String str2, int m, int n, int[][] dp) {

        // agar second string empty hai
        // kisi bhi string ke subsequnce dekhein to usme ek empty string bhi hota hai
        // isliye answer is 1
        // e..g. subsequnces of "abc" are ["", abc, ab, bc, ac,a , b , c]
        // Notice ek subsequnce "" hota hai har string ka ..aur is base case mai str2 ""
        // hai islye answer 1 hoga
        if (n == 0) {
            return dp[m][n] = 1;
        }

        // E.g. str1= geeksgeeks and str2= gks;
        // If first string is empty, and you have to find "gks"
        // how many ways you can find it, there is no way (0)
        if (m == 0) {
            return dp[m][n] = 0;
        }

        // memoization
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // get last charcter of first string
        char a = str1.charAt(m - 1);
        char b = str2.charAt(n - 1);

        // E.g. str1= geeksgeeks and str2= gks;
        int x1 = Count_DistinctSub(str1, str2, m - 1, n - 1, dp); // geeksgeek, gk
        int x2 = Count_DistinctSub(str1, str2, m - 1, n, dp); // geeksgeek, gks

        // if last charcter of both are same than iterate till m-1, n-1, else 1
        // less from each and get minimum
        if (a == b) {
            return dp[m][n] = x1 + x2;// notice we have to find all possible subseq hence adding all the possibilities
        } else {
            return dp[m][n] = x2;
        }
        // return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "rabbbit", word2 = "rabbit";

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = Count_DistinctSub(word1, word2, word1.length() - 1, word2.length() - 1,
                dp);
        System.out.println(result);

    }
}
