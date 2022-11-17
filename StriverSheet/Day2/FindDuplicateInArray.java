package StriverSheet.Day2;

// LC 287: https://leetcode.com/problems/find-the-duplicate-number/

// Approach: Uses Floyd Cycle Detection algorithm

// https://www.youtube.com/watch?v=pavdSf5f5pw
// Step1 : Detect Intersection point using Floyd Cycle detection - Use do-while 
// here because it is not linked list
// Step 2: Reset either slow or fast pointer to 0th index
// Step 3: Move both slow and fast pointer with 1 (same speed) till you find a common value - Use 'while' loop here
// Common value found is duplicate element

// Explanation why this approach works: https://www.youtube.com/watch?v=-YiQZi3mLq0
// FindDuplicateInArray-Explanation.png

public class FindDuplicateInArray {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // find intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // reset slow or fast to nums[0]
        slow = nums[0];
        while (slow != fast) { // Notice here we have to while loop instead of do-while
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {

        // int[] nums = { 1, 3, 4, 2, 2 };
        int[] nums = { 3, 1, 3, 4, 2 };
        int result = findDuplicate(nums);
        System.out.println(result);
    }

}
