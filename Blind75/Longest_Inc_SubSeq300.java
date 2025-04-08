package Blind75;

// Question: https://leetcode.com/problems/longest-increasing-subsequence/?envType=problem-list-v2&envId=oizxjoit
// Solution: https://www.youtube.com/watch?v=odrfUCS9sQk

public class Longest_Inc_SubSeq300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        int maxLength = 0;
        for (int i = 0; i < dp.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Longest_Inc_SubSeq300 lis = new Longest_Inc_SubSeq300();
        int[] nums = { 0, 1, 0, 3, 2, 3 }; // Example input

        int result = lis.lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + result); // Output: 4
    }
}
