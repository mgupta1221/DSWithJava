package StriverSheet.Day1_Arrays;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

    // LC 31: https://leetcode.com/problems/next-permutation/

    // Approach:

    // Step 1: Move from right to left and find an element where num[i] < num[i+1]
    // -> store i index
    // Step 2: Again move from R to L -> Find an element greater than num[i] ->
    // store j index
    // Step 3: Swap element at index i and j
    // Step 4: Reverse the elements from index i+1 till the end

    // Full explanation :
    // https://www.youtube.com/watch?v=LuLCLgMElus

    public static void nextPermutation(int[] nums) {

        if (nums.length == 0)
            return;

        int i = nums.length - 2;

        // Step 1
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        // Step 2
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i])
                j--;
            // Step 3
            swap(nums, i, j);
        }

        // Step 4
        reverse(nums, i + 1, nums.length - 1);
    }

    public static void reverse(int[] nums, int l, int r) {
        while (l < r)
            swap(nums, l++, r--);
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int nums[] = { 1,5,1 };
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

}
