package Blind75;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        CumHelper(candidates, target, 0, subResult, result);
        return result;
    }

    public static void CumHelper(int[] cand, int target, int idx,
            List<Integer> subResult, List<List<Integer>> result) {
        if (target == 0) {
            if (!result.contains(subResult)) {
                result.add(new ArrayList<>(subResult));
            }
            return;
        }
        if (idx == cand.length) {
            return;
        }

        if (target - cand[idx] >= 0) {
            subResult.add(cand[idx]);
            CumHelper(cand, target - cand[idx], idx, subResult, result);
            subResult.remove(subResult.size() - 1);
        }
        CumHelper(cand, target, idx + 1, subResult, result);
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
