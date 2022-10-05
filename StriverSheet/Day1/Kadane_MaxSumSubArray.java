package StriverSheet.Day1;

import java.util.ArrayList;
import java.util.List;

public class Kadane_MaxSumSubArray {

    // LC 53: https://leetcode.com/problems/maximum-subarray/

   

    // Full explanation :
    // https://www.youtube.com/watch?v=VMtyGnNcdPw&t=1s

    // Approach 1: Brute Force O(n^2)
    public static int maxSumSubArray_Approach1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum = currentSum + nums[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;

    }
   
    // Approach 2: Kadane's Algo O(n)
    public static int maxSumSubArray_Approach2(int[] nums, List<Integer> indexes) {
        int max_ending_here = nums[0];
        int maxSum = nums[0];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            max_ending_here += nums[i];
            if (max_ending_here < nums[i]) {
                max_ending_here = nums[i];
                startIndex = i;
            }
            if (max_ending_here > maxSum) {
                maxSum = max_ending_here;
                endIndex = i;
            }

        }
        indexes.add(startIndex);
        indexes.add(endIndex);

        return maxSum;

    }

    public static void main(String[] args) {
        // int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int nums[] = { -1, -2 };
        // maxSumSubArray_Approach1(nums);

        List<Integer> indexes = new ArrayList<>(); // this is to store the start and end of index of longest subArray
        int result_maxSum = maxSumSubArray_Approach2(nums, indexes);
        System.out.println("MaxSum: " + result_maxSum);
        System.out.println("Start Index: " + indexes.get(0));
        System.out.println("End Index: " + indexes.get(1));

    }

}
