package PepLevelUp.DP;

public class FriendsParing {

    // Problem not on Leetcode
    // https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1
    // Solution explanation: https://www.youtube.com/watch?v=SHDu0Ufjyk8
    public static int countFriendsPairings(int n) {
        int[] dp = new int[n];
        return countFriendsPairingsHelper(n, dp);

    }

    // recursive memoized DP
    public static int countFriendsPairingsHelper(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = 1;
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int x = countFriendsPairingsHelper(n - 1, dp);
        int y = (n - 1) * countFriendsPairingsHelper(n - 2, dp);
        dp[n] = x + y;
        return dp[n];

    }

    public static void main(String[] args) {
        int n = 2;
        int result = countFriendsPairings(n);
        System.out.println(result);
    }
}
