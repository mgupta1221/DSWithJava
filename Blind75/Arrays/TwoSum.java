package Blind75.Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int reqNumber = target - nums[i];
            if (hMap.containsKey(reqNumber)) {
                result[0] = hMap.get(reqNumber);
                result[1] = i;
                break;
            }
            hMap.put(nums[i], i);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = { 11, 7, 11, 2, 15 };
        int target = 9;

        int result[] = twoSum(nums, target);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
