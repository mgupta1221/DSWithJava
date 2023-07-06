package AdobeQues;

import java.util.ArrayList;
import java.util.Collections;

public class PartitionEqualSubsetSum {

    // Problem: https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
    // LC 416 https://leetcode.com/problems/partition-equal-subset-sum/

    // This is similar to TargetSum
    // Return 1 if array can be partitoned , else 0

    static int equalPartition(int N, int arr[]) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if (totalSum % 2 == 1) {
            return 0;
        }
        Boolean[][] dp = new Boolean[N][totalSum + 1];
        return equalPartitionHelper(arr, 0, totalSum / 2, dp) ? 1 : 0;
    }

    static boolean equalPartitionHelper(int arr[], int idx, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (idx == arr.length || target < 0) {
            return false;
        }

        if (dp[idx][target] != null) {
            return dp[idx][target];
        } else {
            dp[idx][target] = equalPartitionHelper(arr, idx + 1, target, dp)
                    || equalPartitionHelper(arr, idx + 1, target - arr[idx], dp);
            return dp[idx][target];
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 11, 5 };
        int result = equalPartition(4, arr);
        System.out.print(result + " ");

    }
}
