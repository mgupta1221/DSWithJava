package StriverSheet.Day25_DP;


// Problem: LC 300 https://leetcode.com/problems/longest-increasing-subsequence/

public class Longest_Increasing_SubSequence {

    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int maxlength = 1;

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1; // this is important to remember
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) { // this check so that last stored higher value in dp[i] should not get
                                             // updated, say dp[i] = 3 and in next iteration dp[j] + 1 comes 2 so it
                                             // should not update dp[i]
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            maxlength = Math.max(maxlength, dp[i]);
        }
        return maxlength;

    }

    public static void main(String[] args) {
        // int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 }; /// ans: 4 --- {2,3,7,101}
        // 1 1
        int[] nums = { 0, 1, 0, 3, 2, 3 }; // ans: 4 ---{0,1,2,3}
        int result = lengthOfLIS(nums);
        System.out.println(result);
    }

}
