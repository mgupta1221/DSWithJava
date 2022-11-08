package StriverSheet.Day10_RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

// LC 46 : Check GeeksForGeeks solution

public class PrintPermutationsOfString {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        permuteHelper(nums, 0, nums.length, result);
        return result;

    }

    public static void permuteHelper(int[] nums, int idx, int n,
            List<List<Integer>> result) {

        if (idx == nums.length) {
            List<Integer> subResult = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                subResult.add(nums[i]);
            }
            result.add(new ArrayList<>(subResult));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            nums = swap(nums, idx, i);
            permuteHelper(nums, idx + 1, n, result);
            nums = swap(nums, idx, i);
        }

    }

    public static int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = permute(nums);
        for (int i = 0; i < result.size(); i++) {

            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }
    }
}
