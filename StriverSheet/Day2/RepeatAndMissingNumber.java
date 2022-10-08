package StriverSheet.Day2;

// LC 287:
//https://www.interviewbit.com/problems/repeat-and-missing-number-array/

// Problem: You are given a read only array of n integers from 1 to n.
// Each integer appears exactly once except A which appears twice and B which is missing.
// Return A and B.

// Approach:

// For logic:
// Pepcoding - All Repeating Except Two | Two Unique Rest Twice | Bit Manipulation Interview Questions
// https://www.youtube.com/watch?v=pnx5JA9LNM4&list=PL-Jc9J83PIiE-181crLG1xSIWhTGKFiMY&index=48

// For actual question:
// Pepcoding - Find Duplicate Number and Missing Number from 1 to N 
// https://www.youtube.com/watch?v=MvklwzVz654&list=PL-Jc9J83PIiE-181crLG1xSIWhTGKFiMY&index=49

public class RepeatAndMissingNumber {

    public static int[] repeatedNumber(int[] nums) {

        int xXORy = 0;

        for (int n : nums) {
            xXORy = xXORy ^ n;
        }
        for (int i = 1; i <= nums.length; i++) {// not that it is starting from 1 not 0
            xXORy = xXORy ^ i;
        }

        // Get right most set bit
        int rmsb = xXORy & -xXORy;

        int x = 0;
        int y = 0;
        for (int n : nums) {
            if ((n & rmsb) == 0) { // '&' is used so that we can group the elements with different
                                   // right most set bit
                x = x ^ n;
            } else {
                y = y ^ n;
            }
        }
        // Notice we have to do XOR with 1...N too.
        for (int i = 1; i <= nums.length; i++) {
            if ((i & rmsb) == 0) {
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }

        // Now we dont know which one in x and y is repeated and which is missing number
        int missingNumber = 0;
        int repeatedNumber = 0;
        for (int n : nums) {
            if (x == n) {
                repeatedNumber = x;
                missingNumber = y;
            } else {
                repeatedNumber = y;
                missingNumber = x;
            }
        }
        int[] n = { missingNumber, repeatedNumber };
        return n;

    }

    public static void main(String[] args) {

        int[] nums = { 3, 1, 2, 5, 3 }; // Expected output 3,4
        int[] result = repeatedNumber(nums);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

}
