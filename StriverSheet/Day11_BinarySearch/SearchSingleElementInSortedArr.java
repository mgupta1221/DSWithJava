package StriverSheet.Day11_BinarySearch;

public class SearchSingleElementInSortedArr {

    // LC: 540: https://leetcode.com/problems/single-element-in-a-sorted-array/

    // One solution is XOR, , other soltuion is via Binary Search

    // Approach: https://www.youtube.com/watch?v=PzszoiY5XMQ&t=194s

    // https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/

    static int findSingleElement(int nums[]) {

        int low = 0;
        int high = nums.length - 2; // notice we are taking this till lenth-2

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    high = mid - 1;

                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };

        int result = findSingleElement(arr);
        System.out.println(result);
    }

}
