package StriverSheet.Day9_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LC 40: https://leetcode.com/problems/combination-sum-ii/

// Coins can repeat in this

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (!result.contains(subResult))
                    result.add(new ArrayList<>(subResult));
            }
            return;
        }

        // Candidate aayega
        // or, repeat nahi hoga(isliye idx+1),
        // aur target reduce kar do
        if (idx < candidates.length && target - candidates[idx] >= 0) {
            subResult.add(candidates[idx]);
            combinationSumHelper(candidates, idx + 1, target - candidates[idx], subResult, result);
            subResult.remove(subResult.size() - 1);
        }

        // this is important to avoid TLE - we are avoiding additional recursive calls
        // if next element is same as ppearing in the sorted array
        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }
        combinationSumHelper(candidates, idx + 1, target, subResult, result);

    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);

        for (int i = 0; i < result.size(); i++) {

            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
