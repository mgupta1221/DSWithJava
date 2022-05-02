package PepLevelUp.DP;

public class TargetSumSubset {

    // Solved using Iterative DP
    // This uses 2D array unlike Coin Change (which uses 1 D array for DP iterative
    // solution)

    // - Key note - Agar duplicacy chahiye to 1D , else use 2D array
    
    // THis proble uses the logic ya to number aayega ya nahi aayega
    // Solution Video
    // https://www.youtube.com/watch?v=tRpkluGqINc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=11
    private static boolean TargetSumSubset_Iterative(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    // 2 possibilities here- ya to number aayega ya nahi aayega
                    // agar number NAHI aayega to upper row [i-1][j] wala answer copy ho jayega
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        // agar number aayega to number mai se nums[i-1] less karke answer aa jayega
                        // See video for explanation of this
                        if (j >= nums[i - 1]) {
                            dp[i][j] = dp[i - 1][j - nums[i - 1]];
                        }
                    }
                }
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 13, 6 };
        int target = 7;

        boolean result = TargetSumSubset_Iterative(nums, target);
        System.out.println(result);
    }
}
