package Blind75;

public class Min_InRotatedSortedArray153 {

    // Not efficient: Using For loop
    public int findMin2(int[] nums) {
        int min = nums[0];
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                min = nums[i + 1];
                break;
            }
        }
        return min;
    }

    // Efficient: Uses Binary Search
    public static int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        int result = findMin(nums);
        System.out.println(result);
    }

}
