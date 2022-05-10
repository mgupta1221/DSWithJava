package PepLevelUp.DP;

public class Count_Longest_Decreasing_SubSeq {

    // Solution - DP solution - Check Increasing subsequnce for logic

    private static int count_Longest_Decreasing_SubSeq_tabulation(int[] arr, int idx, int[] dp) {

        dp[0] = 1;

        int maxlength = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) { // Diff from LIS: Greater than has been changed to <
                    if (dp[j] < dp[j] + 1) {// this condition is changed 
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            if (dp[i] > maxlength) {
                maxlength = dp[i];
            }
        }

        return maxlength;

    }

    public static void main(String[] args) {
        int[] arr = { 15, 27, 14, 38, 63, 55, 46, 65, 85 };

        int[] dp = new int[arr.length];
        int result = count_Longest_Decreasing_SubSeq_tabulation(arr, 0, dp);
        System.out.println(result);
    }
}
