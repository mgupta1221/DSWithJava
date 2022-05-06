package PepLevelUp.DP;

public class EditDistance {

    // Problem:
    // https://www.geeksforgeeks.org/edit-distance-dp-5/

    // Tabulation solution video for logic:
    // https://www.youtube.com/watch?v=We3YDTzNXEk

    // Code :
    // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
    // Trick diagram -: "EditDistance.png"
    // Notice first row and first column are for empty charcters and filled with
    // numbers adjacent
    /// E..g for the cell circles it means- how many operations are needed to create
    // "abc"(see row) . Answer will be 3 as 3 Inserts are required(a,b,c).
    //
    public static int minDistance(char[] word1, char[] word2) {
        int[][] dp = new int[word1.length + 1][word2.length + 1];
        return minDistanceHelper(word1, word2, dp);
    }

    public static int minDistanceHelper(char[] word1, char[] word2, int[][] dp) {
        // filling first column with 0,1,2,3...
        // Notice we are running till word1.length in below loop becuase 1 row is
        // occupied with empty
        // See trick diagram
        for (int i = 0; i <= word1.length; i++) {
            dp[i][0] = i;
        }
        // filling first row with 0,1,2,3...
        // same logic as above to run till word2.length
        for (int i = 0; i <= word2.length; i++) {
            dp[0][i] = i;
        }
        // running loop from 1 below becuase 1st row and columns are already filled
        // and notice till word1.length
        for (int i = 1; i <= word1.length; i++) {
            for (int j = 1; j <= word2.length; j++) {
                if (word1[i - 1] == word2[j - 1]) {
                    // if letters are same copy left diagonal cell's value..see above video
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // if letters are differnet than take min of left cell, upper cell and
                    // left diagonal cell and add 1 (1 is for the operation).
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[word1.length][word2.length];

    }

    // Recursive solution
    // Solution desc : https://www.geeksforgeeks.org/edit-distance-dp-5/
    public static int minDistance_recursive(char[] word1, char[] word2, int m, int n) {
        int[][] dp = new int[word1.length + 1][word2.length + 1];

        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        // If last characters of two strings are same,
        // nothing much to do. Ignore last characters and
        // get count for remaining strings.
        if (word1[m - 1] == word2[n - 1]) {
            return minDistance_recursive(word1, word2, m - 1, n - 1);
        }
        // If last characters are not same, consider all
        // three operations on last character of first
        // string, recursively compute minimum cost for all
        // three operations and take minimum of three
        // values.
        int x = minDistance_recursive(word1, word2, m, n - 1);
        int y = minDistance_recursive(word1, word2, m - 1, n);
        int z = minDistance_recursive(word1, word2, m - 1, n - 1);

        return Math.min(x, 1 + Math.min(y, z));
    }

    // Recursive solution- with memoization
    // Solution desc : https://www.geeksforgeeks.org/edit-distance-dp-5/
    public static int minDistance_recursiveMemo(char[] word1, char[] word2, int m, int n) {
        int[][] dp = new int[word1.length + 1][word2.length + 1];

        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        int x = minDistance_recursive(word1, word2, m, n - 1);
        int y = minDistance_recursive(word1, word2, m - 1, n);
        int z = minDistance_recursive(word1, word2, m - 1, n - 1);

        if (word1[m - 1] == word2[n - 1]) {
            return dp[m][n] = z;
        }
        return dp[m][n] = Math.min(x, 1 + Math.min(y, z));
    }

    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";
        // Tabulation method
        // int result = minDistance(word1.toCharArray(), word2.toCharArray());
        // System.out.println(result);

        // recursive method
        // int result = minDistance_recursive(word1.toCharArray(), word2.toCharArray(),
        // word1.length(), word2.length());
        // System.out.println(result);

        // recursive method with memoization
        int result = minDistance_recursiveMemo(word1.toCharArray(), word2.toCharArray(), word1.length(),
                word2.length());
        System.out.println(result);

    }
}
