package PepLevelUp.DP;


// LC 
public class CoinChangePermutation {

    // Iterative DP apprach- Solution 1
    // (uses 1DArray to solve)
    // Solition video:
    // https://www.youtube.com/watch?v=yc0LunmJA1A&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=14
    private static int CoinChangePermutation_Iterative(int[] coins, int target) {
        int[] dp = new int[target + 1]; 

        dp[0] = 1;// initialize with 1

        // Agar coin repeat karna hai to Coin ka loop andar chalao - Permutation 
        // Agar Coin repeat NAHI karna hai to Coin ka loop bahar chalao - Combination

        for (int i = 1; i < dp.length; i++) { // 0 to targetAmount- 'i' amount ko store karne ke kitne tareeke hain
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = dp[i] + dp[i - coins[j]];
                }
            }
        }
        return dp[target];

    }

    public static void main(String[] args) {

        int[] coins = new int[] { 2, 3, 5, 6 };
        int totalAmt = 7;

        int result = CoinChangePermutation_Iterative(coins, totalAmt);
        System.out.println(result);
    }
}
