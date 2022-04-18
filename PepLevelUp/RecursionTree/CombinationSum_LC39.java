package PepLevelUp.RecursionTree;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_LC39 {
    // Appraoch 1: For loop approach
    public static int combinationSum(int[] arr,
            int target,
            int idx,
            List<List<Integer>> ans, List<Integer> smallAns) {

        if (target == 0) {
            List<Integer> tempAns = new ArrayList<>(smallAns);// Notice we are creating new list
            ans.add(tempAns);
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) { // start this loop from 0 if want permutations
            if (target - arr[i] >= 0 && arr[i] > 0) {
                int temp = arr[i];

                smallAns.add(temp);

                count += combinationSum(arr,
                        target - temp,
                        i + 1, // change this to 'i' so that will turn to 'permutation' which means
                        // same coin can also repeat in the result
                        ans, smallAns);

                smallAns.remove(smallAns.size() - 1);

            }
        }
        return count;
    }

    // Approach 2: Using Subsequence - Ek bar element lena hai...ek bar bina element
    // ke
    // This approach does not use For Loop

    private static void combinationSum_subsequence(int[] coins, int target, int idx, List<List<Integer>> result,
            List<Integer> tempResult) {

        if (idx == coins.length || target == 0) {
            if (target == 0) {
                result.add(new ArrayList<>(tempResult));
            }
            return;
        }

        if (target - coins[idx] >= 0) {
            tempResult.add(coins[idx]);
            combinationSum_subsequence(coins, target - coins[idx], idx, result, tempResult);
            tempResult.remove(tempResult.size() - 1);
        }
        combinationSum_subsequence(coins, target, idx + 1, result, tempResult);

    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7 };
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        int result = combinationSum(arr, 7, 0, ans, smallAns);

        // combinationSum_subsequence(arr, 7, 0, ans, smallAns);
        for (List<Integer> a : ans) {
            for (Integer b : a) {
                System.out.print(b);
            }
            System.out.println();
        }

    }
}
