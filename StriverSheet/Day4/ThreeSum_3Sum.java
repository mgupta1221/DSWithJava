package StriverSheet.Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum_3Sum {

    // LC 15 - https://leetcode.com/problems/3sum/
    // Problem : return all the triplets [nums[i], nums[j], nums[k]] such that i !=
    // j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0

    // Approach: 2 pointer appraoch-
    // Approach: Sort the array, and then fix two pointers, so the remaining sum
    // will be (target – (nums[i] + nums[j])). Now we can fix two-pointers, one
    // front, and another at the end, and use a two-pointer to find the
    // remaining two numbers of the triplet. We can
    // easily jump duplicates, by skipping the same elements by running a loop.
    // Notice the while loop inside 'if' conditions to avoid duplicates

    // Full explanation here:
    // https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/

    // Different solutons approaches:
    // https://leetcode.com/problems/3sum/discuss/2676313/Java-binary-search-two-pointers-or-hashmap-or-5-solutions

    // For below apparoach: //Time: O(N * LogN + N * N); Space : O(LogN)
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);// Sorting the array is important in this approach

        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = nums[i];
            int m = i + 1;
            int n = nums.length - 1;

            while (m < n) {
                int sum = num1 + nums[m] + nums[n];
                if (sum == 0) {
                    List<Integer> subresult = new ArrayList<>();
                    subresult.add(num1);
                    subresult.add(nums[m]);
                    subresult.add(nums[n]);
                    result.add(subresult);
                    n--; // this is important else infinite loop when sum =0
                    while (m < n && nums[n] == nums[n + 1]) {
                        n--;
                    }
                } else if (sum < 0) {
                    m++;
                    // for bypassing same consecutive numbers to avoid duplicates
                    while (m < n && nums[m] == nums[m - 1]) {
                        m++;
                    }
                } else if (sum > 0) {
                    n--;
                    while (m < n && nums[n] == nums[n + 1]) {
                        n--;
                    }
                }
                // this is also for duplicates but very imporant to avoid [-1,0,1] repeating
                // twice in result
                while (m < n && nums[i] == nums[i + 1]) {
                    i++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> result = threeSum(nums);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
