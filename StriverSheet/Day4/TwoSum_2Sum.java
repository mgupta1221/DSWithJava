package StriverSheet.Day4;

import java.util.HashMap;

public class TwoSum_2Sum {

    // LC 1 - https://leetcode.com/problems/two-sum/
    // Problem : Return indices of the two numbers such that they add up to target.
    // Approach: Using hashMap, storing the remaining difffernce Target-nums[i]

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        HashMap<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int reqNumber = target - nums[i];
            if (hMap.containsKey(reqNumber)) {
                result[0] = hMap.get(reqNumber);
                result[1] = i;
            } else {
                hMap.put(nums[i], i);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int result[] = twoSum(nums, target);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result);
        }

    }
}
