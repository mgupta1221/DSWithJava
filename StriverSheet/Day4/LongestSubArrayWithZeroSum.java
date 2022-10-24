package StriverSheet.Day4;

import java.util.HashMap;

public class LongestSubArrayWithZeroSum {

    // https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

    // Solution approach: https://www.youtube.com/watch?v=_yGf2rxwZlA

    // We keep calculating the sum at each index. Idea is when same sum value
    // repeats than all numbers in between current Index and Index at last
    // occurence of that sum - make sum as 0
  

    public static int maxLen(int nums[], int n) {

        int maxCount = 0;

        int sum = 0;
        int currentLength = 0;
        HashMap<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // Below 'if' is for TLE - If sum from 0th index is 0, than this is the longest
            // sum possible till i
            if (sum == 0) {
                maxCount = i + 1;

            } else {
                if (hMap.containsKey(sum)) {
                    currentLength = i - hMap.get(sum);
                    maxCount = Math.max(maxCount, currentLength);
                } else {
                    hMap.put(sum, i);
                }
            }

        }
        return maxCount;

    }

    public static void main(String[] args) {
        int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };

        int result = maxLen(nums, nums.length);

        System.out.println(result);

    }
}
