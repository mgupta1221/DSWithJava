package StriverSheet.Day25_DP;

// Problem :https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1

// Same as Increasing Sum Subsequence except that 
// 1) dp will not hold the count but the max Sum till that index, and,
// 2) the condition "if(dp[i] < dp[j] + arr[i])"  becuase dp[j] will hold the maxSum
//  till index j and if adding arr[i] will make it bigger than update it

public class Max_Sum_Increasing_Subseq {
    public static int maxSumIS(int arr[], int n) {
        int[] dp = new int[n];
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i]; // here it will be initialized with arr[i]
            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + arr[i]) {
                        dp[i] = dp[j] + arr[i];
                    }
                }
            }
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 101, 2, 3, 100 };
        int[] arr = { 27, 39, 22, 35, 3, 38, 48, 4, 19 };
        int result = maxSumIS(arr, arr.length);
        System.out.println(result);

    }

}
