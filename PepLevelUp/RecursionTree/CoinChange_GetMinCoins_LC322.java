
package PepLevelUp.RecursionTree;

//LEETCODE 322
public class CoinChange_GetMinCoins_LC322 {
    public static int coinChange(int[] coins, int target) {
        int result = coinChangeHelper(coins, target, 0);
        if (result != (int) 1e9) {
            return result;
        }
        return -1; // return -1 if minimum could not be found
    }

    // Full explanation given in word doc
    public static int coinChangeHelper(int[] coins, int target, int idx) {
        if (target == 0) {
            return 0;
        }

        // Check image in doc file why we are adding 1 at line 17 below
        int min = (int) 1e9; // use this, instead of Integer.MAX_VALUE
        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                min = Math.min(min, 1 + coinChangeHelper(coins, target - coins[i], i));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        var result = coinChange(coins, 10);
        System.out.println(result);
    }
}
