package StriverSheet.Day4;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {

    // LC 3:
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/

    // Solution: https://www.youtube.com/watch?v=dvXyTOYVxB8

    // Approach:
    // Sliding Window
    // Traverse the string characters and maintain 2 variables: i and j
    // starting from 0. As we traverse ,we will keep storing characters in
    // hashSet(and keep increasing j as we move). If a repeated element appears, we
    // will remove all elements till duplicacy is removed and keep increasing 'i' by
    // 1 at each removal (sliding window). We will maintain max length with unique
    // characters at each iteration using: (j-i+1)

    //// imagine 'abca' - while loop below will work till first 'a' is removed

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int len = s.length();
        int maxLength = Integer.MIN_VALUE;
        HashSet<Character> hSet = new HashSet<>();

        while (j < len) {
            char currentChar = s.charAt(j);
            if (hSet.contains(currentChar)) {
                while (i < j && hSet.contains(currentChar)) {
                    hSet.remove(s.charAt(i)); /// Notice how are removing element from left one by one using HashSet
                    i++;
                }
            }
            hSet.add(currentChar);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;

    }

    public static void main(String[] args) {
        String s = "pwwkew";

        int result = lengthOfLongestSubstring(s);
        System.out.println(result);

    }
}
