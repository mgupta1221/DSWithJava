package GettingStartedBasics.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Leetcode 901 : https://leetcode.com/problems/online-stock-span/

//Solution video:
// https://www.youtube.com/watch?v=0BsPlzqksZQ&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=10

// Approach same as 'Next Greater Element' just that in that we traversed from end
//  of the array, here we traversed from 0 to n-1

public class StockSpanProblem {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

       
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 5, 1, 3, 10, 6, 7 };
        int[] nums2 = { 2, 5, 1, 3, 10, 6, 7 };
        int[] result = nextGreaterElement(nums1, nums2);

        for (int n : result)
            System.out.print(n + " ");

    }
}
