package PepLevelUp.DP;

// LC 70 https://leetcode.com/problems/climbing-stairs/
// Solution video : https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=3
// Solved using Recursive approach
// See Trick diagram in same folder: ClimbStairs1.png
public class ClimbStairs {

    // This question was also solved using recursion in "RecursionWithArayList"
    // section with name 'GetStairPaths'
    // Difference is here we need the count and not the actual paths and we will
    // solve it with DP

    // Question link:
    // https://nados.pepcoding.com/content/0/e3d771f8-96eb-4ea2-b186-437eacf6ab11/
    // 1. You are given a number n, representing the number of stairs in a
    // staircase.
    // 2. You are on the 0th step and are required to climb to the top.
    // 3. In one move, you are allowed to climb 1, 2 or 3 stairs.
    // 4. You are required to print the number of different paths via which you can
    // climb to the top

    // Solution video -
    // https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=2

    // This uses Tabulation (Iterative) method of DP

    // This solution uses tabulation(iterative) method of DP
    public static int countPathsWithTabulation(int n) {

        int[] dp = new int[n + 1];
        // Step 1: meaning assign karte hain har ek cell pe ki ith index pe value
        // store hogi ki ith index se 0th floor pe jaane ke kitne raste hain
        // e.g. arr[4] pe store hoga ki 4 se 0 pe jaane ke kitne raste hain

        // [ 0 | 1 | 2 | 3 | 4 | 5 | 6 ]

        //// to choti problem ye hai 0 se 0 pe jane ka rate kewal 1 hai,
        // kyunki 6 se 0 to solve karna hai
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            // we are doing till 'n-2' becuase one can make up to 2 steps(1-2) only
            // on each move as per the question
        }
        return dp[n - 1];

    }

    // This solution uses recursion with memoization
    public static int countPaths(int n, int[] dp) {
        // this is important to return 1 if i=0
        if (n == 0) {
            return 1;

        } else if (n < 0) {
            return 0;
        }
        if (dp[n] > 0) {
            return dp[n];
        }

        int pathsN1 = countPaths(n - 1, dp);
        int pathsN2 = countPaths(n - 2, dp);
        int totalPaths = pathsN1 + pathsN2;

        dp[n] = totalPaths;

        return totalPaths;
    }

    public static void main(String[] args) {
        int n = 3;

        // Approach 1: using Tabulation(iterative) mehtod of DP
        // int numOfpaths = countPathsWithTabulation(n);
        // System.out.println(numOfpaths);

        // Approach 2: using DP memoization solution
        int[] dp = new int[n + 1]; // creating a question bank to avoid
        // solving same problem again and again
        int numOfpaths2 = countPaths(n, dp);
        System.out.println(numOfpaths2);

    }

}