package StriverSheet.Day7;

public class RemoveDuplictesFromSortArray {

    // LC 26 - https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

        // int lastNum = nums[0];
        // int k = 1;
        // for (int i = 1; i < nums.length; i++) {

        // while (lastNum == nums[i] && i < nums.length - 1) {
        // i++;
        // }
        // if (i < nums.length && lastNum != nums[i]) {
        // nums[k++] = nums[i];
        // lastNum = nums[i];
        // }
        // }
        // return k;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3, 3 };

        int result = removeDuplicates(nums);
        System.out.println((result));

    }

}
