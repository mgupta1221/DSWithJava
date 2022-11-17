package StriverSheet.Day3;

public class MajorityElement_I {

    // LC 169: https://leetcode.com/problems/majority-element/
    // The majority element is the element that appears more than ⌊n / 2⌋ times.

    // Apprch 1: Using HashMap, Store the count for each element. Space Complexity:
    // O(N)

    // Approach 2: Moore's algo: From the problem, we can say majority element's
    // count is more than N/2.

    // So when we traverse through the array we try to keep track of the count of
    // elements and which element we are tracking.

    // Initialize 2 variables:
    // Count – for tracking the count of element
    // Element – for which element we are counting

    // Idea is Majority element will survive till the end even if we do count--

    // Explanation:
    // https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/

    public static int majorityElement(int[] nums) {

        int currentNum = 0;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                currentNum = n;
                count++;
            }
            if (currentNum == n) {
                count++;
            } else {
                count--;
            }
        }
        return currentNum;

    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 2, 2, 4 };

        int result = majorityElement(nums);
        System.out.println(result);
    }

}
