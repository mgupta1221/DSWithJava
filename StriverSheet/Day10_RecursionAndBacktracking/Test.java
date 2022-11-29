package StriverSheet.Day10_RecursionAndBacktracking;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static boolean solveSudoku(char[][] board) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return null;

    }

    public static void permuteHelper(int[] nums, int idx, List<List<Integer>> result) {
       
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        permute(nums);

    }

}
