package PepLevelUp.DP;

public class ClimbStairsWithVariableJump {

    // Question link:
    // https://nados.io/question/climb-stairs-with-variable-jumps

    // 1. You are given a number n, representing the number of stairs in a
    // staircase.
    // 2. You are on the 0th step and are required to climb to the top.
    // 3. You are given n numbers, where ith element's value represents - till how
    // far from the step you could jump to in a single move.
    // 4. You are required to print the number of different paths via which you can
    // climb to the top.

    // Differnce between this Question and ClimbingStairs is that in that problem,
    // we could travel
    // only -1, -2 and -3 steps at a time, here number of steps are variable.

    // Solution video -
    // https://www.youtube.com/watch?v=uNqoQ0sNZCM

    public static void countPathsWithTabulation(int[] sNos) {
        int n = sNos.length;

        // Step 1: dp will store 'i' index se 'n'(top stair) tak jaane ke kitne raste
        // hain
        // e.g. dp[0] pe store ki 0th floor se top floor pe jaane ke kitne raste hain
        // to choti problem ye hai 6 se 6 pe jane ka raste kewal 1 hai
        int[] dp = new int[n];
        dp[n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= sNos[i] && (i + j) < n; j++) {
                // agar arr[i]=2, to hum i se i+1 and i+2 hi jaa sakte hain
                dp[i] = dp[i] + dp[i + j];
            }
        }

        System.out.println(dp[0]);

    }

    public static void main(String[] args) {
        // int[] stairNumbers = { 2, 4, 1, 0, 2, 3 };
        int[] stairNumbers = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
        countPathsWithTabulation(stairNumbers);

    }

}