package Blind75;

import java.util.HashSet;

public class LongestConsecutiveSeq128 {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int currentNum;
        int count = 1;
        int maxCount = 1;
        int i = 0;
        while (i < nums.length) {
            currentNum = nums[i];
            count = 1;
            while (set.contains(currentNum - 1)) {
                count++;
                currentNum = currentNum - 1;
                maxCount = Math.max(maxCount, count);

            }
            i++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }
}
