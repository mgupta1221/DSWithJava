package AdobeQues;

// Problem: https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers5647/1

// This is like KnapSack problem -  Either element will come or not come.
// We have used a variable 'memo' to avoid TLE
// Becuase the values can be too big, so we will do [mod%] with 1e9+7  at each step;

// Solution video: https://www.youtube.com/watch?v=8qDhW1Owcfo

public class SumOfPowerOfNums {
    static int mod = 1000000000 + 7;

    static int numOfWays(int n, int x) {

        Integer[][] memo = new Integer[n + 1][n + 1];// to avoid TLE, memoization - Notice we are using INTrger and not
                                                     // integer for null check
        return numOfWaysHelper(1, n, x, memo) % mod;
    }

    static int numOfWaysHelper(int idx, int targetSum, int x, Integer[][] memo) {
        if (targetSum == 0) {
            return 1;
        }
        if (targetSum < 0 || idx > targetSum) // if requiredSum <0 or currentNumber is greater than requiredSum
            return 0;

        int power = (int) Math.pow(idx, x);
        if (power > targetSum)
            return 0;
        if (memo[idx][targetSum] != null) {
            return memo[idx][targetSum];
        }

        int pick = numOfWaysHelper(idx + 1, targetSum - power, x, memo); // idx will come
        int notpick = numOfWaysHelper(idx + 1, targetSum, x, memo); // idx will not come

        return memo[idx][targetSum] = ((pick % mod) + (notpick % mod)) % mod; // add both, save it in memo and return

    }

    public static void main(String[] args) {
        int n = 100;
        int x = 2;

        int result = numOfWays(n, x);
        System.out.println(result);
    }
}
