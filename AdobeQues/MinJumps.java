package AdobeQues;

public class MinJumps {

    // Greedy Problem
    // Problem:
    // https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
    // https://leetcode.com/problems/jump-game-ii/

    // Solution : https://www.youtube.com/watch?v=Yrw3MNh_368

    public static int jump(int[] nums) {
        int n = nums.length; // length of the nums array
        int jumps = 0; // number of jumps needed to reach the end
        int curEnd = 0; // farthest index that can be reached with the current number of jumps
        int curFarthest = 0; // farthest index that can be reached from the current index

        // iterate over the nums array from 0 to n - 2 (last index pe jump nai leni,
        // wahan ruk jana hai)
        for (int i = 0; i < n - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]); // update curFarthest with the maximum distance that can
                                                              // be reached from this index

            // isme hum ye check kar rhe hain..kya peeche wale index ne mujhe better answer
            // diya tha - basically jaise hi 'i' curEnd se match karta hai (iska matlab hum
            // current position par pahuch gaye hain) - hum 'curEnd' ko ab tak ke maximum
            // reached index(which is 'curFarthest' that is calculated at each iteration
            // hence it is maximum reachable point till here) se update kar denege or jump
            // ka count bhi badha denge
            if (i == curEnd) {
                jumps++; // increment jumps by 1
                curEnd = curFarthest; // update curEnd with the new farthest index
            }

            // AS we reach end we will return the answer, else -1 (this condition is becuase
            // of the condition in the question that retunr -1 if could not reach the end)
            if (curEnd >= n - 1) {
                return jumps;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        int result = jump(nums);
        System.out.println(result);
    }
}
