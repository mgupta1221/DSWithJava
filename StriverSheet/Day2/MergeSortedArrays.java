package StriverSheet.Day2;

// LC 88: https://leetcode.com/problems/merge-sorted-array/

// Approach:
// https://www.youtube.com/watch?v=C4oBXLr3zos - For quick approach understanding
// https://www.youtube.com/watch?v=73lyz0EZye8 - Code is from this video

// Start from end of the both arrays and keep comparing the index values and keep storing the higher
// value in Array 1's end such that:

// If element of Array 1 > Element of Array 2 =>  Store the "element of Array 1" at last index of array 1
// If element of Array 1 < Element of Array 2 =>  Store the "element of Array 2" at last index of array 1

//There is an Edge case when Array 1 has only 1 element as {0}. 
// E.g. 
// int nums1[] = { 0 };
// int nums2[] = { 1 };

// so if you reduce Array 1 index, it will become -1 so we have to add 2 while loops

public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int idx1 = m - 1;
        int idx2 = n - 1;
        int idx_array1 = m + n - 1;

        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] > nums2[idx2]) {
                nums1[idx_array1] = nums1[idx1];
                idx1--;
                idx_array1--;
            } else {
                nums1[idx_array1] = nums2[idx2];
                idx2--;
                idx_array1--;
            }

        }
        // Added below for edge cases
        while (idx1 >= 0) {
            nums1[idx_array1] = nums1[idx1];
            idx1--;
            idx_array1--;

        }
        while (idx2 >= 0) {
            nums1[idx_array1] = nums2[idx2];
            idx2--;
            idx_array1--;
        }
    }

    public static void main(String[] args) {

        // Final array should be stored inside the array nums1. To accommodate this,
        // nums1 has a length of m + n, where the last n elements are set to 0 and
        // should be ignored.

        // int nums1[] = { 1, 2, 3, 0, 0, 0 };
        // int m=3;
        // int nums2[] = { 2, 5, 6 };
        // int n=3;

        // Edge case 1
        int nums1[] = { 0 };
        int m = 0;
        int nums2[] = { 1 };
        int n = 1;

        // Edge case 2
        // int nums1[] = { 2, 0 };
        // int m = 1;
        // int nums2[] = { 1 };
        // int n = 1;

        merge(nums1, m, nums2, n);

        // printing result
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }

    }

}
