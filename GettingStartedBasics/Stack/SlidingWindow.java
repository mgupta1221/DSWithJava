package GettingStartedBasics.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Given an array of integers of size ‘n’, Our aim is to calculate the maximum 
// sum of ‘k’ consecutive elements in the array.

// Input  : arr[] = {100, 200, 300, 400}, k = 2
// Output : 700

// Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4 
// Output : 39

public class SlidingWindow {
    public static int SlidingWindowSolver(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            int newSum = maxSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, newSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        int result = SlidingWindowSolver(nums, 4);

        System.out.print(result);

    }
}
