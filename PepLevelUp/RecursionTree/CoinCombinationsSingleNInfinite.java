package PepLevelUp.RecursionTree;

import java.util.ArrayList;
import java.util.List;

// Infinite here means 1 coin can be used multiple times
// Single means 1 coin can be used only once
// say you have 2,3,5,7 coins, you have to form 10(target=10) so Combination(Single) will be (235) and (37).

public class CoinCombinationsSingleNInfinite {

    // Approach 1 which uses loop and recursion
    // In permutation , you CANNOT move backward
    // We use additonal parameter here in case of combination i.e. index(idx)
    // becuase we cannot go backward so we make changes in loop to run from 'idx'
    // instead of '0'
    // Same coin can be used multiple times
    private static int CoinChangeCombination_In(int[] coins, int tar, String psf, int idx) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        // diff between permutation and combination if loop starts with idx since we
        // cannot move backard
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

    // 2nd approach which uses subsequence strategy- Cannot re-use the same coin
    // again
    private static int CoinChangeCombination_Single_SubSeqeunce(int[] coins, int tar, String psf, int idx) {
        // adding another condition below idx == coins.length as base case , notice OR
        // condition
        // this condition is required becuase we are not usin FOR loop which will end
        // itself
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        // for loop removed
        if (tar - coins[idx] >= 0) {
            // this below is when we are considering current coin
            count += CoinChangeCombination_Single_SubSeqeunce(coins, tar - coins[idx], psf + coins[idx] + " ", idx + 1);
        }
        // this below is when not considering current coin
        count += CoinChangeCombination_Single_SubSeqeunce(coins, tar, psf, idx + 1);

        return count;
    }

    // 2nd approach : using subsequence
    private static int CoinChangeCombination_Infinite_SubSeqeunce(int[] coins, int tar, String psf, int idx) {
        // adding another condition below idx == coins.length as base case , notice OR
        // condition
        // this condition is required becuase we are not usin FOR loop which will end
        // itself
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        // for loop removed
        if (tar - coins[idx] >= 0) {
            // this below is when we are considering current coin
            count += CoinChangeCombination_Infinite_SubSeqeunce(coins, tar - coins[idx], psf + coins[idx] + " ", idx);
        }
        // this below is when not considering current coin
        count += CoinChangeCombination_Infinite_SubSeqeunce(coins, tar, psf, idx + 1);

        return count;
    }

    // private static int CoinChangeCombination_Infin2(int[] coins, int target, String psf, int idx) {

    //     List<List<Integer>> result = new ArrayList<List<Integer>>();
    //     if (idx == coins.length || target == 0) {
    //         if (target == 0) {
    //             System.out.println(psf);
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     int count = 0;

    //     if (target - coins[idx] >= 0) {
    //         count += CoinChangeCombination_Infin2(coins, target - coins[idx], psf + coins[idx] + " ", idx);
    //     }
    //     count += CoinChangeCombination_Infin2(coins, target, psf, idx + 1);
    //     return count;
    // }

  

    public static void main(String[] args) {
        int[] coins = { 10, 1, 2, 7, 6, 1, 5 };

        // var result = CoinChangeCombination_In(coins, 10, "", 0);
        // var result = CoinChangeCombination_Single(coins, 10, "", 0);
        // var result = CoinChangeCombination_Single_SubSeqeunce(coins, 8, "", 0);
        var result = CoinChangeCombination_Infinite_SubSeqeunce(coins, 10, "", 0);
        // var result = CoinChangeCombination_Infin2(coins, 5, "", 0);
        System.out.println("Count: " + result);
    }
}
