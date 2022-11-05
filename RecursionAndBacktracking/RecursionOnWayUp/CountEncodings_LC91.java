package RecursionAndBacktracking.RecursionOnWayUp;

import java.util.Arrays;

public class CountEncodings_LC91 {

    // If time is less for revision and check the DP approach below. Check video for
    // explanation

    // Approach 1: Recursion

    // We take an 'index' which goes from 0 to n - 1 where n is the length of
    // string.

    // Base Condition "index==str.length": Question gives us that the minimum length
    // of string is 1. If we start from i = 0 and reach i = 1, then we see that
    // there is just one way to decode.

    // if(i == n) return 1; //for example, think that you are given "2" as the
    // input.

    // Another condition that's given in question is if 0 is leading, there is no
    // possible way.

    // Now for the faith part, we move index to next position by either index + 1 or
    // index + 2
    // (because these are the two choices and we code for our choices in recursion).
    // Note that the string becomes smaller as I move forward.
    // Now comes the additional logic in code that we've discussed.

    // The question has another condition when you take two characters at once : it
    // should be less than or equal to 26 (alphabets have 26 characters).

    public static int numDecodings(String str, int index) {

        if (index == str.length())
            return 1;

        char firstchar = str.charAt(index);
        if (firstchar == '0')
            return 0;

        int count = numDecodings(str, index + 1);// Running for 1 character

        // Running for 2 characters
        if (index + 1 < str.length()) {
            String firstTwoChars = str.substring(index, 2);
            int charVal = Integer.parseInt(firstTwoChars);
            if (charVal <= 26)
                count += numDecodings(str, index + 2);
        }
        return count;
    }

    // Approach improved: Recursion with memoization
    // Above recursive will cause TLE, so below is the memoized code
    private static int numDecodings_memo(String str, int i, int[] mem) {
        int n = str.length();
        if (i == n)
            return 1;
        if (str.charAt(i) == '0')
            return 0;
        if (mem[i] != -1)// if this sub-problem has already been solved, don't go and invoke another
                         // series of recursive call. Get the result from cache
            return mem[i];
        int count = numDecodings_memo(str, i + 1, mem);
        if (i + 1 < str.length()) {
            String firstTwoChars = str.substring(i, 2);
            int charVal = Integer.parseInt(firstTwoChars);
            if (charVal <= 26)
                count += numDecodings(str, i + 2);
        }
        return mem[i] = count;// store result for each sub-problem
    }

    // Approach 2: With DP
    // Solution https://www.youtube.com/watch?v=o1i7JYWbwOE
    private static int numDecodings_DP(String str) {

        int[] dp = new int[str.length() + 1];

        dp[0] = 1;
        dp[1] = str.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= str.length(); i++) {
            int firstChar = Integer.parseInt(str.substring(i - 1, i)); // say value is
            int secondChar = Integer.parseInt(str.substring(i - 2, i));

            // For 1 char : E.g. for value '5' in "73421[5]" same count as for "73421"
            if (firstChar > 0)
                dp[i] += dp[i - 1];

            // For 2 chars: E.g. // E.g. for value '5' in "7342[15]" same count as for
            // "7342"
            if (secondChar >= 10 && secondChar <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[str.length()];
    }

    public static void main(String[] args) {

        String str = "1201234";

        // Appaorach 1: With Recursion
        // int ans = numDecodings(str, 0);

        // Apparoch 1 (Optimized): Recursion with memo
        // int[] mem = new int[str.length()];
        // Arrays.fill(mem, -1);
        // int ans = numDecodings_memo(str, 0, mem);
        // System.out.println(ans);

        // Approach 2 :: DP
        int ans = numDecodings_DP(str);
        System.out.println(ans);

    }

}
