package StriverSheet.Day1;

public class SortArray0s1s2s {

    // LC 75: https://leetcode.com/problems/sort-colors/

    // Approach 1 - Merge Sort - O(NlogN)

    // Approach 2 - Iterate and Count number of 0s, 1s and 2s
    // Iterate again and store them again in the array
    // Not "in place" - Space Complexity is O(1)

    // Approach 3 - O(N):(solved with this approch below)
    // Maintain 3 pointers low, mid and high
    // Inititalize low = 0, mid = 0 and high = nums.length-1

    // Now till mid < high
    // if nums[mid]=0 : swap numbers at low and mid, low++, mid++
    // if nums[mid]=1 : mid++
    // if nums[mid]=0 : swap numbers at mid and high, high--

    // Important in this algo, we assume:
    // [ 0....low-1] are 0
    // [ high + 1...n] are 2

    // Full explanation :
    // https://www.youtube.com/watch?v=sEQk8xgjx64

    public static void SortArray0s1s2s(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {   // <= is important , not <
            int currentNum = nums[mid]; // Get nums[m] as current Number
            if (currentNum == 0) {
                swap(nums, low, mid); // first swap and than increment
                low++;
                mid++;
            }
            if (currentNum == 1) {
                mid++;
            }
            if (currentNum == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };

        SortArray0s1s2s(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

}
