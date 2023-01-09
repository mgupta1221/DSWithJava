package StriverSheet.Day26;

import java.util.Arrays;

// Problem: LC 1547 https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

// Solution video: https://www.youtube.com/watch?v=lbEAWQibVDE

// This problem is a variation of UNBOUNDED KNAPSACK

// Solution appraoch:
// 1. We sort the cuts array

// 2. We call the recursive function which will have with 4 parameters:
// i)   rod_start, ii) rod_end, - these are for rod (not cuts) 2 find the cost of cut
// iii) left index iv) right index of the rod   <- these are for cuts

// 3. In recursive function, loop through all possible cuts ( notice from left -> right, NOT 0 -> cuts.length) to find
//    the minimum cost possible.

// 4. In each iteration - we will split the rod into 2 halfs and keep finding the minimum value. 

// 5. After the loop completes, the minimum cost found is the answer

public class RodCutting {
    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int dp[][] = new int[101][101]; // in the question cuts limit is 1-to-100

        // populating dp with -1
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return minCost_helper(dp, 0, n, cuts, 0, cuts.length - 1);
    }

    public static int minCost_helper(int dp[][], int stick_start, int stick_end, int[] cuts, int left, int right) {
        if (right < left) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int left_result = minCost_helper(dp, stick_start, cuts[i], cuts, left, i - 1);
            int right_result = minCost_helper(dp, cuts[i], stick_end, cuts, i + 1, right);
            int result = (stick_end - stick_start) + left_result + right_result;// calculating the current cost
            min = Math.min(min, result); // finding minimum
        }
        return dp[left][right] = min;

    }

    public static void main(String[] args) {
        int[] cuts = { 1, 3, 4, 5 };
        int n = 7;
        int result = minCost(n, cuts);
        System.out.println(result);
    }

}
