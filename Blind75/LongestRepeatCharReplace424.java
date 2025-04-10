package Blind75;

import java.util.HashMap;

public class LongestRepeatCharReplace424 {

    // Sliding Window Problem
    // Solution video: https://www.youtube.com/watch?v=y0-x7GSTzu0

    // Idea
    // Intution is We will use Sliding window with left and right variable. Both
    // starting from 0.
    // We will iterate through the string and at each point we will calculate the
    // Maximum repeating Charcter (using Hashmap for this) and current window size
    // which will be (right-left+1)

    // We will then calculate length of count of non-repeating chacarters count
    // by WindowSize-MaxRepeatingCharCount

    // Now if Non-repeating characters count is greater than 'k' than means we
    // cannot replace these many chacrters so we will reduce the window size

    // If it is less than or equal to 'k' than we will keep finding MaxLength of
    // string till that point using CurrentWindowSize

    public static int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int windowSize = 0;
        int maxRepeatingCharCount = 0;
        int maxWindowSizeResult = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            Character currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // Getting maxRepeatingCharCount
            // Notice the maxCharCount is derived from current Charcter
            maxRepeatingCharCount = Math.max(maxRepeatingCharCount, map.get(currentChar));

            // getting Non-repeating charcter count from current window size
            windowSize = right - left + 1;
            int nonrepeat = windowSize - maxRepeatingCharCount;

            // If non-repeatingCharCount > k as we cannot replace these many charcters
            // then reduce the window size by removing the value(left++) from window
            // ELSE get the maxWindowSize each time(for the result)
            // Notice, how we are getting variable at left below to reduce its count in
            // HashMap
            if (nonrepeat > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            } else {
                maxWindowSizeResult = Math.max(maxWindowSizeResult, windowSize);
            }
        }
        return maxWindowSizeResult;

    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        int len = characterReplacement(s, k);
        System.out.println(len);
    }
}
