package StriverSheet.Day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem: https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1
// On leetcode LC : 132 https://leetcode.com/problems/palindrome-partitioning-ii/

// Apparoch 1: Using print substrings approach Striver Sheet_Day9-recursion
// Approach 2: Using MCM Format

public class PallindromicPartitioning_MCM {

    public static int palindromicPartition(String s) {
        // Note that we are not using result and subResult as we do not have to
        // print the subStrings but just have to find the minumum number of cuts.
        List<List<String>> result = new ArrayList<>();
        List<String> subResult = new ArrayList<>();
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        // using print substrings approach Striver Sheet_Day9-recursion
        // int minimumCuts = partition_helper(s, result, subResult, 0, s.length(), dp) -
        // 1;

        // Solved using MCM approach
        int[][] dp2 = new int[2001][s.length() + 1];
        for (int[] ks : dp2) {
            Arrays.fill(ks, -1);
        }
        int minimumCuts = partition_helper_usingMCMFormat(s, result, subResult, 0,
                s.length() - 1, dp2);

        return minimumCuts;

    }

    public static int partition_helper(String s, List<List<String>> result, List<String> subResult, int index, int len,
            int[] dp) {
        if (index == len) {
            return 0;
        }
        if (dp[index] != -1)
            return dp[index];

        int min = Integer.MAX_VALUE;
        for (int i = index; i < len; i++) {
            if (isPallendrome(s, index, i)) {
                // subResult.add(s.substring(index, i + 1)); // add the substring with +1 , not
                // 'S'
                min = Math.min(min, 1 + partition_helper(s, result, subResult, i + 1, len, dp));
                // subResult.remove(subResult.size() - 1);
            }
        }
        return dp[index] = min;

    }

    // Solving via MCM format
    public static int partition_helper_usingMCMFormat(String s, List<List<String>> result, List<String> subResult,
            int i, int j,
            int[][] dp2) {
        if (i >= j) {
            return 0;
        }
        if (dp2[i][j] != -1)
            return dp2[i][j];

        if (isPallendrome(s, i, j) == true) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempAns = 1 +
                    partition_helper_usingMCMFormat(s, result, subResult, i, k, dp2) +
                    partition_helper_usingMCMFormat(s, result, subResult, k + 1, j, dp2);

            min = Math.min(min, tempAns);
        }
        return dp2[i][j] = min;

    }

    public static boolean isPallendrome(String s, int i, int j) {
        while (i <= j) {
            char charleft = s.charAt(i);
            char charRight = s.charAt(j);

            if (charleft != charRight) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {
        String str = "ababbbabbababa"; // ans : 3
        // 3 partitioning substrings are "a", "babbbab", "b", "ababa".

        // int result =partition(str);

        int result = palindromicPartition(str);

        System.out.println(result);

    }
}
