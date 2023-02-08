package StriverSheet.Day9_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class test1 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        subsetSums_helper(nums, result, subResult, 0);
        return result;

    }

    public static void subsetSums_helper(int[] nums, List<List<Integer>> result, List<Integer> subResult, int idx) {

        if (idx == nums.length) {
            if (!result.contains(subResult)) {
                result.add(new ArrayList<>(subResult));
            }
            return;
        }

        subResult.add(nums[idx]);
        subsetSums_helper(nums, result, subResult, idx + 1);
        subResult.remove(subResult.size() - 1);
        subsetSums_helper(nums, result, subResult, idx + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };

        List<List<Integer>> result = subsetsWithDup(nums);

        System.out.println(result);
    }

}