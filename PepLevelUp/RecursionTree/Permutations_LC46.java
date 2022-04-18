package PepLevelUp.RecursionTree;

import java.util.ArrayList;
import java.util.List;

//LEETCODE 46 - Explnation in Mar 28 video
//This prgram below is for returning the set of permutations of a array

//To print all permutations, we use swapping logic in backtracking mode as given in below link
//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

public class Permutations_LC46 {
    public static void getPermutations(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> smallAns = new ArrayList<Integer>();
        getPermutationsHelper(nums, 0, ans, smallAns);
        for (List<Integer> l1 : ans) {
            for (Integer n : l1) {
                System.out.print(n + " ");
            }

            System.out.println();
        }

    }

    public static int getPermutationsHelper(int[] nums, int idx, List<List<Integer>> ans,
            List<Integer> smallAns) {

        if (idx == nums.length) {
            List<Integer> tempResult = new ArrayList<>(smallAns); // creating a deep copy of 'ans'
            // because if we are going to make changes in smallAns later, so chnages there
            // will start reflecting here as well (in the one already added in 'ans')
            ans.add(tempResult);
            return 1;
        }

        int count = 0;

        for (int n = 0; n < nums.length; n++) {
            if (nums[n] != -11) {
                int item = nums[n];
                nums[n] = -11; // If we dont set and unset the element in array, than that number will repeat
                // e.g. "1 1 2" and "2 1 1" both will come in result
                smallAns.add(item);
                count += getPermutationsHelper(nums, idx + 1, ans, smallAns);
                nums[n] = item;
                smallAns.remove(smallAns.size() - 1);
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[] coins = { 1,2,3 };
        getPermutations(coins);
    }
}
