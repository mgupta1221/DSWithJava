package StriverSheet.Day9_Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LC 39: https://leetcode.com/problems/combination-sum/

// Coins can repeat in this

// Before starting the recursive call make sure to sort the elements because the ans 
// should contain the combinations in sorted order and should not be repeated

// Time Complexity: O(2^t * k) where t is the target, k is the average length
// Reason: Assume if you were not allowed to pick a single element multiple times, every
// element will have a couple of options: pick or not pick which is 2^n different recursion
// calls, also assuming that the average length of every combination generated is k. (to put
// length k data structure into another data structure)
// Why not (2^n) but (2^t) (where n is the size of an array)?
// Assume, that there is 1 and the target you want to reach is 10 so 10 times you 
// can “pick or not pick” an element.

// Space Complexity: O(k*x), k is the average length and x is the no. of combinations

public class CombinationSumI {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> subResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target, subResult, result);
        return result;

    }

    public static void combinationSumHelper(int[] candidates, int idx, int target,
            List<Integer> subResult,
            List<List<Integer>> result) {

        if (idx == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(subResult));
            }
            return;
        }
        // Candidate aayega
        // or, repeat hoga(isliye idx nahi badhaya),
        // aur target reduce kar do
        
        if (target - candidates[idx] >= 0) {
            subResult.add(candidates[idx]);
            combinationSumHelper(candidates, idx, target - candidates[idx], subResult, result);
            subResult.remove(subResult.size() - 1);
        }
        // Candidate nahi aayega to idx badha ho aur target as it is rakho
        combinationSumHelper(candidates, idx + 1, target, subResult, result);

    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);

        for (int i = 0; i < result.size(); i++) {

            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
