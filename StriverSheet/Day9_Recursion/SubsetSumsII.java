package StriverSheet.Day9_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem: https://leetcode.com/problems/subsets-ii/

public class SubsetSumsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // important to avoid [1,4,4] and [4,1,4] (different order). If array is sorted
                           // such occurence will not happen
        subsetSumsHelper(nums, 0, subResult, result);
        return result;
    }

    public static void subsetSumsHelper(int[] nums, int idx, List<Integer> subResult,
            List<List<Integer>> result) {
        if (idx == nums.length) {
            if (!result.contains(new ArrayList<>(subResult))) // important to avoid duplicates like [1,4,4] comign twice
                result.add(new ArrayList<>(subResult));
            return;
        }

        subResult.add(nums[idx]);
        subsetSumsHelper(nums, idx + 1, subResult, result);
        subResult.remove(subResult.size() - 1);
        subsetSumsHelper(nums, idx + 1, subResult, result);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 4, 4, 1, 4 };
        List<List<Integer>> result = subsetsWithDup(arr);

        for (int i = 0; i < result.size(); i++) {

            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
