package AdobeQues;


public class CountStairs {

    // Problem:
    // https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1
    // LC 70 https://leetcode.com/problems/climbing-stairs/

    static int countWays(int n) {
        int[] dp = new int[n + 1];
        return countWaysHelper(n, dp);
    }

    static int countWaysHelper(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        return dp[n] = countWaysHelper(n - 1, dp) + countWaysHelper(n - 2, dp);
    }

    public static void main(String[] args) {
        int result = countWays(4);
        System.out.print(result + " ");

    }
}
