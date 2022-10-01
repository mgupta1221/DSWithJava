package StriverSheet.Day1;

import java.util.ArrayList;
import java.util.List;

public class ReturnAllPermutationOfArray {

    // LC 46: https://leetcode.com/problems/permutations/

    // Approach:

    public static void permuteRecur(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            List<Integer> tempResult = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                tempResult.add(nums[i]);
            }
            result.add(tempResult);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permuteRecur(nums, index + 1, result);
            swap(nums, i, index);
        }

    }

    public static List<List<Integer>> permuteMain(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteRecur(nums, 0, result);
        return result;

    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        List<List<Integer>> result = permuteMain(nums);
        System.out.println("All Permutations are");
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

}
