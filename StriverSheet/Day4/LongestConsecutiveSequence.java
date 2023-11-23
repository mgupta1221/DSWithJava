package StriverSheet.Day4;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // LC 128: https://leetcode.com/problems/longest-consecutive-sequence/

    // Probelm Desc: Given an unsorted array, return the length of the
    // longest consecutive elements sequence. E.g. [100,4,200,1,3,2] =Ans: 4 i.e. [1,2,3,4]

    // Approach: We store all numbers in a hashSet. We run a FOR loop on array and
    // than run a WHILE loop inside to check all the numbers above ith element
    // present in the Hashset in a consectuive order, by adding +1 everytime. We
    // keep taking maxCount to preserve the highest count. To prevent TLE, we added
    // an 'if' condition to only execute while loop for the numbers which are the
    // starting point of the consectuive series, this we do by checking if the
    // HashSet contains (x-1) or not..
    // E.g. for e.g. 4,3,2 ke liye while loop nahi chalega becuase inka lessr
    // element array mai present hai

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> hSet = new HashSet<>();
        for (int n : nums) {
            hSet.add(n);
        }
        int maxCount = 1;

        for (int i = 0; i < nums.length; i++) {
            if (!hSet.contains(nums[i] - 1)) { // Without this TLE will come, basically array mai us element se chota
                                               // element nahi hona chhaiye, tabhi 'while' loop se bade elements check
                                               // karo. So, in this case, [4,3,2] ke liye 'while' loop nahi chalega,
                                               // kewal 1 ke liye chalega, so TLE will not occur
                int count = 1;
                int j = 1;
                while (hSet.contains(nums[i] + j)) {
                    count++;
                    j++;
                    maxCount = Math.max(maxCount, count);
                }
            }

        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = longestConsecutive(nums);
        System.out.println(result);
    }
}
