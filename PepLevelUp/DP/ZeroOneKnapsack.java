package PepLevelUp.DP;

// This is similar to Target Sum Subset

// Problem: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
// Tabulation method
// Solution video
// https://www.youtube.com/watch?v=bUSaenttI24&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=16

// Trick diagram (ZeroOneKnapsack.png)
// Notice first row is blank(considering team mai koi player hi nahi hai) so all
// cell values in first row will be 0 since team hi nahi hai to run kaise banenge
// Cell values in first column will also be 0 becuase ball hi nahi hai(column 1 is 0 ) to run 
// kaise banenege 
public class ZeroOneKnapsack {
    private static int ZeroOneKnapsack_Tabulation(int[] vals, int[] weights, int target) {

        // E.g.
        // int[] weights = { 2, 5, 1, 3, 4 };
        // int[] val = { 15, 14, 10, 45, 30 };
        // target = 7;

        // vals on x axis and target values in y axis
        int[][] dp = new int[vals.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0 || j == 0) { // i=0 means ball hi nahin to play, y=0 means players hi nahi hain
                    dp[i][j] = 0;
                } else {
                    if (j < weights[i - 1]) { // e.g. agar balls 2 hain(column value represented as j) aur player 4
                                              // balls khelta hai(represented as weights[i-1]) to player ke pass ek hi
                                              // option hai ki batting nahi karega
                                              // aur upar wale cell ki value copy kar lo kyunki baaki khelenge
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // else case - agar available balls jyada hain to maximum nikala
                        // jayega...agar batting kare aur agar nahi kare jitne player khel sakta hai
                        // -- to player batting karega
                        int x = dp[i - 1][j]; // agar batteing nahi kare
                        int y = dp[i - 1][j - weights[i - 1]] + vals[i - 1]; // agar baatting kare

                        dp[i][j] = Math.max(x, y);

                    }

                }

            }
        }

        return dp[vals.length][target];
    }

    public static void main(String[] args) {
        int[] weights = { 2, 5, 1, 3, 4 };
        int[] vals = { 15, 14, 10, 45, 30 };
        int target = 7;
        int result = ZeroOneKnapsack_Tabulation(vals, weights, target);
        System.out.println(result);

    }
}
