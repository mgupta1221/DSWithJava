package PepLevelUp.RecursionTree;

// Infinite here means 1 coin can be used multiple times
// Single means 1 coin can be used only once
// say you have 2,3,5,7 coins, you have to form 10(target=10) so Combination(Single) will be (235) and (37).

public class CoinCombinationsSingleNInfinite {

    // In permutation , you CANNOT move backward
    // We use additonal parameter here in case of permutation i.e. index(idx)
    // becuase we cannot go backward so we make changes in loop to run from 'idx'
    // instead of '0'
    //Same coin can be used multiple times
    private static int CoinChangeCombination_In(int[] coins, int tar, String psf, int idx) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        // diff between permutation and combination if loop starts with idx since we
        // cannot
        // move backard
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                // we pass 'i' since we can use the same coin again where we are standing
                count += CoinChangeCombination_In(coins, tar - coins[i], psf + coins[i] + " ", i);
            }
        }
        return count;
    }

    // Cannot re-use the same coin again
    private static int CoinChangeCombination_Single(int[] coins, int tar, String psf, int idx) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                // we will pass 'i+1' since we cant repeat same coin
                count += CoinChangeCombination_Single(coins, tar - coins[i], psf + coins[i] + " ", i + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        // var result = CoinChangeCombination_In(coins, 10, "", 0);
        var result = CoinChangeCombination_Single(coins, 10, "", 0);

        System.out.println("Count: " + result);
    }
}
