package StriverSheet.Day26;

import java.util.Arrays;

// Problem: https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1
// We DO NOT have to find the minimum floor but number of attempts needed to find the minimum floor

// Solution video:  https://www.youtube.com/watch?v=qUOPn5KNoRA: 

// Approach:  
//1. We try from '0' to 'n' floors in a loop, see the helper function : (We had to use helper function to pass 
//  memoization dp as parameter to avoid TLE)

//2. In each iteration, we try to drop the egg and see if it breaks, or, survives and we take the max of 
// the 2 kyunki maximum of the 2 lene se pata chal jayega ki maximum itne attempt mai to break ho hi
// jayega us floor ke liye..ye max hum har floor (each iteration) pe nikalenge and than we will get 
// the 'minimum' of all 'maxvalues' of all floors to get the final answer.

// Logic: Remember manager ne kaam diya 4 bando ko..har banda ka maxtime hai kaam karne ka , aur mintime hai (mintime wo hai 
// ki wo pressure mai kitna jaldi kar sakta hai)..maxtime aur mintime ka 'max' nikalne se ye pata chal jayega
// ki itne time mai to wo kaam kar hi dega

// fir saare bando ke 'max' ka minimum nikalne se pata chal jayega ki minimum kitne time mai wo kaam ho jayega

public class EggDropping {

    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int eggDrop(int n, int k) {

        // memoization to avoid TLE
        int[][] dp = new int[n + 1][k + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return eggDrop_helper(n, k, dp);
    }

    // helper
    static int eggDrop_helper(int n, int k, int[][] dp) {

        // Base case : if only 1 egg
        if (n == 1) {
            return k;
        }

        // Base case : if only 1 floor
        if (k == 1) {
            return 1;
        }

        // Base case: No eggs , OR, no floors
        if (k == 0 || n == 0) {
            return 0;
        }
        // return memoized solution
        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        // main logic
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            int l = eggDrop_helper(n - 1, i - 1, dp);
            int r = eggDrop_helper(n, k - i, dp);

            int tempResult = Math.max(l, r);
            min = Math.min(min, tempResult);
        }
        dp[n][k] = min + 1; // Notice we are adding + 1 becuase to do this assessment of egg break, or, egg survive we have
                            // already attempted once so that should be counted
        return min + 1;

    }

    public static void main(String[] args) {
        int result = eggDrop(4, 3);
        System.out.println(result);

    }
}
