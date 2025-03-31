package Blind75;

// The difference between a [substring,or subArray] and a 'subsequence' 
// is the criterion of contiguity. The symbols that make up a longest common substring/subArray 
// must appear in both strings as a contiguous string.

// Problem: LC 152 https://leetcode.com/problems/maximum-product-subarray/

// Apparoach: Kadane's algo:
// Follow the below steps to solve the problem:

// 1. Here we use 3 variables called max_so_far, max_ending_here & min_ending_here

// 2. For every index, the maximum number ending at that index will be the maximum(arr[i], max_ending_here * arr[i], 
// min_ending_here[i]*arr[i])

// 3. Similarly, the minimum number ending here will be the minimum of these 3

// We have to calculate 'min_ending_here' becuase of negative nums 
// e.g. { -2, 3, -4 } - in this case
// maxProduct sum should be 24 , After first iteration max_ending_here = 3,
// min_ending_here = -6 
// we have to use both of these to calculate the maxProduct.

// Note: This is solved in single loop only

public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {

        int maxProduct_till_here = nums[0];
        int minProduct_till_here = nums[0];
        int maxProductResult = nums[0];

        // /* Traverse through the array.
        // the maximum product subarray ending at an index
        // will be the maximum of the element itself,
        // the product of element and max product ending
        // previously and the min product ending previously.
        // */

        for (int i = 1; i < nums.length; i++) {

            // Notice we are temporarily storing 'max_Product_Sum_till_here' because
            // next step mai min_Product_sum ki calculation mai inhi variables ko use karna
            // hai to abhi update nahi kar
            // sakte 'maxProduct_till_here' ki value ko
            int temp = Math.max(nums[i],
                    Math.max(nums[i] * maxProduct_till_here, nums[i] * minProduct_till_here));

            minProduct_till_here = Math.min(nums[i],
                    Math.min(nums[i] * maxProduct_till_here, nums[i] * minProduct_till_here));

            maxProduct_till_here = temp; // now updating maxProduct_till_here

            maxProductResult = Math.max(maxProductResult, maxProduct_till_here); // getting the final maxProduct

        }
        return maxProductResult;
    }

    public static void main(String[] args) {
        // int[] nums = { 2, 3, -2, 4 };
        // int[] nums = { 0, 2 };
        int[] nums = { -2, 3, -4 };
        // int[] nums = { -4, -3, -2 };
        int result = maxProduct(nums);
        System.out.println(result);
    }

}
