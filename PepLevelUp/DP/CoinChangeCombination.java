package PepLevelUp.DP;

 // LC 518
public class CoinChangeCombination {
   
    // Combination means 2,2,3 and 2,3,2 will be counted once only

    // Recursive DP apprach- Solution 1
    private static int CoinChangeCombination_Recursive(int[] nums, int target) {
        return CoinChange_Recursive_Helper(nums, target, 0);
    }

    // Recurseive helper
    private static int CoinChange_Recursive_Helper(int[] nums, int target, int idx) {
        if (target == 0) {
            return 1;
        }
        int totalCount = 0;
        for (int i = idx; i < nums.length; i++) {
            int pending = target - nums[i];
            if (pending >= 0) { // Important note that is is greater than Equal to
                totalCount += CoinChange_Recursive_Helper(nums, pending, i);
            }
        }
        return totalCount;

    }

    // Iterative DP apprach- Solution 2
    // (uses 1DArray to solve)
    // Solition video:
    // https://www.youtube.com/watch?v=l_nR5X9VmaI&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=14
    private static int CoinChangeCombination_Iterative(int[] coins, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;// initialize with 1

        // Agar coin repeat karna hai to Coin ka loop andar chalao - Permutation 
        // Agar Coin repeat NAHI karna hai to Coin ka loop bahar chalao - Combination


        for (int i = 0; i < coins.length - 1; i++) { // 2 3 5 6- Have to check for all coins one after the other
            for (int j = coins[i]; j < dp.length; j++) { // 2 to coins.length
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[target];

    }

    public static void main(String[] args) {
        int[] coins = new int[] { 2, 3, 5, 6 };
        int totalAmt = 7;
        // int result = CoinChangeCombination_Recursive(coins, totalAmt);
        // System.out.println(result);

        int result = CoinChangeCombination_Iterative(coins, totalAmt);
        System.out.println(result);
    }
}
