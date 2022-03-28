package PepLevelUp.RecursionTree;

// Infinite here means 1 coin can be used multiple times
// Single means 1 coin can be used only once
// say you have 2,3,5,7 coins, you have form 10(target=10) so Combination(Single) will be (235) and (37).

public class CoinPermutationsSingleNInfinite {

    // In permutation , you can move backward too
    // Same coin can be used multiple times
    private static int CoinChangePermutation_In(int[] coins, int tar, String psf) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int c = 0; c < coins.length; c++) {
            int rem = tar - coins[c];

            if (rem >= 0) {
                // Notice we are reducing target sum
                count += CoinChangePermutation_In(coins, tar - coins[c], psf + coins[c] + " ");
            }
        }
        return count;
    }

    // Coin to be used only once
    private static int CoinChangePermutation_Single(int[] coins, int tar, String psf) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int c = 0; c < coins.length; c++) {
            int rem = tar - coins[c];

            if (rem >= 0 && coins[c] > 0) {

                // using backtracking so negating the coin value so that it is not taken again
                // check the if conditon too above
                int tempCoinVal = coins[c];// we are doing this since want to use this value later in recurisve call
                coins[c] = -coins[c];
                count += CoinChangePermutation_Single(coins, tar - tempCoinVal, psf + tempCoinVal + " ");
                coins[c] = -coins[c];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        // var result = CoinChangePermutation_In(coins, 10, "");
        var result = CoinChangePermutation_Single(coins, 10, "");
        System.out.println(result);
    }
}
