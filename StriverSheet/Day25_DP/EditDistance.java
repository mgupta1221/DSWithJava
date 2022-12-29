package StriverSheet.Day25_DP;

// Problem: LC 72 Edit Distance

// Tabulation Video : https://www.youtube.com/watch?v=We3YDTzNXEk

// For recursive solution, see // See PepJava\DynamicProgramng\EditDistance.java for approach description

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        int result = minDistance(word1, word2);
        System.out.println(result);

    }

}
