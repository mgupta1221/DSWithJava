package StriverSheet.Day3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement_II {

    // LC 229: https://leetcode.com/problems/majority-element-ii/
    // Find all elements that appear more than ⌊ n/3 ⌋ times.

    // Apprch 1: Using HashMap, Store the count for each element. Space Complexity:
    // O(N)

    // Apprch 2: From the problem, we can say that there cannot be more than 2
    // elements with count > N/3 in an array.

    // Initialize 4 variables:
    // Count1, Count2 – will store their frequency relatively to other numbers.
    // Element1, Element2 – will store our currently most frequent and second most
    // frequent element.

    // Explanation:
    // https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int ele1 = -1;
        int ele2 = -1;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (ele1 == nums[i]) {
                count1++;
            } else if (ele2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                ele1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                ele2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // This below iteration we are doing to remove duplicates as in case of:

        // nums={2,2}

        // Without below iteration -
        // Actual Output: result={2,2}
        // Expected Output: result={2}
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1)
                count1++;
            else if (nums[i] == ele2)
                count2++;
        }

        if (count1 > nums.length / 3) {
            result.add(ele1);
        }
        if (count2 > nums.length / 3) {
            result.add(ele2);
        }

        return result;

    }

    public static void main(String[] args) {
        // int[] nums = { 11, 33, 33, 11, 33, 11 };
        // int[] nums = { 2, 2 };
        int[] nums = { 3, 2, 2, 2, 3 };

        List<Integer> result = majorityElement(nums);
        for (int i = 0; i < result.size(); i++) {

            System.out.print(result.get(i) + " ");
        }
    }

}
