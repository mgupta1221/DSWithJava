package StriverSheet.Day11_BinarySearch;

public class SearchSingleElementInSortedArr {

    // LC: 540: https://leetcode.com/problems/single-element-in-a-sorted-array/

    // One solution is XOR, , other soltuion is via Binary Search

    // Approach: https://www.youtube.com/watch?v=PzszoiY5XMQ&t=194s

    // Below solution is taken from:
    // https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/1587270/C%2B%2B-5-Simple-Solutions-w-Explanation-or-Hashmap-%2B-XOR-%2B-Linear-Search-%2B-Binary-Search

    // Basic idea Binary Search wali appoach ka hai ki hamesha median value ke left
    // side mai first duplicate value ka index even hoga, aur median ke right wale
    // array mai first duplicate value ka index odd hoga

    // E.g. [1,1,2,2,3,4,4,5,5]
    // is array mai median 3 hai...first wale 1 ka index even hai(0) , first wale 2
    // index bhi even hai-- ye dono median ke left mai hai...same way first wale 4
    // ka index odd hai(5) , first wale 5 ka index bhi odd hai(7)

    // Time Complexity : O(logN), each time we are eliminating half of search space
    // using binary search
    // Space Complexity : O(1) only constant extra space is being used.

    static int findSingleElement(int nums[]) {

        int low = 0;
        int high = nums.length - 1;
        int len = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            boolean isMidEven = mid % 2 == 0;

            // neeche condition ka matlab hai ki ye dono answer nahi hain(becuase duplicate
            // values), ab humein dekhna hai ki mid ke left mai dhundhe ya right mai
            if (mid + 1 < len && nums[mid] == nums[mid + 1]) { // case: 1
                if (isMidEven) {// iska matlab mai median ke left side mai hu to mujhe right jana hai
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (mid > 0 && nums[mid] == nums[mid - 1]) { // case: 2
                if (isMidEven) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid]; // case: 3
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        // int arr[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 }; // ans 2
        int arr[] = { 1 };

        int result = findSingleElement(arr);
        System.out.println(result);
    }

}
