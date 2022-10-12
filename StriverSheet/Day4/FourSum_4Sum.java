package StriverSheet.Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Pair {
    int index1;
    int index2;

    Pair(int n1, int n2) {
        this.index1 = n1;
        this.index2 = n2;
    }
}

public class FourSum_4Sum {

    // LC 18 -https://leetcode.com/problems/4sum/
    // Problem : return an array of all the unique quadruplets [nums[a], nums[b],
    // nums[c], nums[d]] such that:
    // 1. a, b, c, and d are distinct.
    // 2. nums[a] + nums[b] + nums[c] + nums[d] == target

    // Approach: See three sum problem approach for this. Just that we have 2 loops
    // in this case instead of 1 there.

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long sumIJ = (long) nums[i] + nums[j];
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    long sum = sumIJ + (long) nums[m] + (long) nums[n];
                    if (sum == target) {
                        List<Integer> subresult = new ArrayList<>();
                        subresult.add(nums[i]);
                        subresult.add(nums[j]);
                        subresult.add(nums[m]);
                        subresult.add(nums[n]);
                        result.add(subresult);
                        n--; // this is important else infinite loop when sum =0
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    } else if (sum < target) {
                        m++;

                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                    } else if (sum > target) {
                        n--;
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    }

                    /// this will be for j and for i too as shown below
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }

            }
            while (i + 1 < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }   

        return result;

    }

    public static void main(String[] args) {
        // int[] nums = { 1, 0, -1, 0, -2, 2 };
        // int target = 0;
        int[] nums = { 2, 2, 2, 2, 2 };
        int target = 8;
      
        List<List<Integer>> result = fourSum(nums, target);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
