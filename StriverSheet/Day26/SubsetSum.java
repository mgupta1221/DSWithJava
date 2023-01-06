package StriverSheet.Day26;
// Problme: LC  416 https://leetcode.com/problems/partition-equal-subset-sum/

import java.util.Arrays;

// Given an integer array nums, return true if you can partition the array into two subsets 
// such that the sum of the elements in both subsets is equal or false otherwise.

// Note: A subset/subsequence is a contiguous or non-contiguous part of
// an array, where elements appear in the same order as the original array.
// For example, for the array: [2,3,1] , the subsequences will be [{2},{3},{1},{2,3},{2,1},{3,1},{2,3,1}} 
// but {3,2} is not a subsequence because its elements are not in the same order as the original array.

// Appraoch: We have to break the array into 2 parts such that sum is equal. This means we can say that sum of all
// numbers in array should be divisible by 2. 
// And if we can find a subarray with total = (sum/2) that would mean array can be divided into 2 subarrays with equal sum

// Solved with 2 approaches below:
// 1. Recursion without memoization
// 2. Recursion with memoization

public class SubsetSum {

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 == 1) {
            return false;
        }

        return targetSum(nums, totalSum / 2);
    }

    // helper function
    public static boolean targetSum(int[] nums, int target) {

        Boolean[][] dp = new Boolean[nums.length + 1][target + 1]; // Default values will be 'null', not 'false' in
                                                                   // 'Boolean' array

        // return targetSum_helper_withoutMemo(nums, 0, target);// without memoization
        return targetSum_helper_withMemo(nums, 0, target, dp); // with memoization
    }

    // recursive helper to find target sum - WITHOUT Memoization -- this causes TLE
    public static boolean targetSum_helper_withoutMemo(int[] nums, int idx, int target) {

        if (target == 0) {
            return true;
        }
        if (idx == nums.length || target < 0) {
            return false;
        }
        if (target < nums[idx]) {
            return targetSum_helper_withoutMemo(nums, idx + 1, target);
        } else {
            return targetSum_helper_withoutMemo(nums, idx + 1, target - nums[idx]) ||
                    targetSum_helper_withoutMemo(nums, idx + 1, target);
        }

    }

    // recursive helper to find target sum - WITH Memoization -- this will NOT cause
    // TLE
    public static boolean targetSum_helper_withMemo(int[] nums, int idx, int target, Boolean[][] dp) {

        if (target == 0) {
            return true;
        }
        if (target < 0 || idx >= nums.length) {
            return false;
        }

        if (dp[idx][target] != null) { // this is important as possibles values can be 'null', true and false
            return dp[idx][target];
        }
        boolean result1 = targetSum_helper_withMemo(nums, idx + 1, target, dp);
        if (target < nums[idx]) {
            return dp[idx][target] = result1;
        } else {
            boolean result2 = targetSum_helper_withMemo(nums, idx + 1, target -
                    nums[idx], dp) || result1;
            return dp[idx][target] = result2;
        }

    }

    public static void main(String[] args) {

        int[] nums = { 1, 5, 11, 5 };
        // int[] nums = { 100, 100, 100, 100, 100, 100, 100, 100 };

        boolean result = canPartition(nums);// Ans: true --- [1, 5, 5] and [11].
        System.out.print(result);

    }

}
