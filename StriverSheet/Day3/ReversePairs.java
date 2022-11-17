package StriverSheet.Day3;

public class ReversePairs {

    // LC: 493 https://leetcode.com/problems/reverse-pairs/

    // Approach: Solved using Merge Sort
    // https://takeuforward.org/data-structure/count-reverse-pairs/

    // Approach details:
    // Time Complexity : O( N log N ) + O (N) + O (N)
    // Reason : O(N) – Merge operation , O(N) – counting operation ( at iteration of
    // i , j doesn’t start from 0 . Both of them move linearly )

    // Space Complexity : O(N)

    // Reason : O(N) – Temporary ArrayList

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            int inv = mergeSort(nums, start, mid); // notice how we are adding inv and sending back to calling function
            inv += mergeSort(nums, mid + 1, end);
            inv += merge(nums, start, mid, end);
            return inv;
        } else {
            return 0;
        }

    }

    public static int merge(int[] nums, int start, int mid, int end) {
        int j = mid + 1;

        // Additional logic for this questions, rest is same as mergeSort
        int cnt = 0;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] > ((long) nums[j] * 2)) { // Notice (long) to handle big input numbers
                j++;
            }
            cnt += j - (mid + 1);// this will be the count becuase j was initally set mid+1 (getting actual
                                 // fcounts)
        }

        // Below can be a simpler way to write abbove logic code with 2 nested loops
        // int cnt=0;
        // for (int k1 = start; k1 <= mid; k1++) {
        // for (int k2 = mid + 1; k2 <= end; k2++) {
        // if (nums[k1] > 2 * nums[k2]) {
        // cnt++;
        // }
        // }
        // }

        // Merge operation begins as in merge sort
        int i = start;
        j = mid + 1;
        int k = 0;
        int[] mergedArray = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                mergedArray[k++] = nums[j++];
            } else {
                mergedArray[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            mergedArray[k++] = nums[i++];
        }
        while (j <= end) {
            mergedArray[k++] = nums[j++];
        }
        for (int l = 0, j1 = start; l < mergedArray.length; j1++, l++) {
            nums[j1] = mergedArray[l];
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3, 1 };
        int result = reversePairs(nums);
        System.out.println(result);

    }

}
