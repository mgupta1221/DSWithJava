package StriverSheet.Day15_Strings;

import java.util.Arrays;

public class LongestCommonPrefix {

    // Problem: LC 14  https://leetcode.com/problems/longest-common-prefix/

    // Appproach:
    // 1. Sort the array of strings in alphabetical order.

    // 2. Compare the characters in the first and last strings in the array. Since the
    // array is sorted, common characters among the first and last element will be
    // common among all the elements of the array.

    // 2.1. If they are same, then append the character to the result.

    // 2.2. Else, stop the comparison – result contains the longest common prefix
    // among the strings in the array.

    public static String longestCommonPrefix(String[] arr) {

        int size = arr.length;
        String result = "";
        // The longest common prefix of an empty array is "".
        if (size == 0) {
            System.out.println("Longest common prefix: ");
        }
        // The longest common prefix of an array containing
        // only one element is that element itself.
        else if (size == 1) {
            System.out.println("Longest common prefix: " + arr[0]);
        } else {
            // Sort the array
            Arrays.sort(arr);
            int length = arr[0].length();
            StringBuilder res = new StringBuilder();
            // Comapre the first and the last strings character
            // by character.
            for (int i = 0; i < length; i++) {
                // If the characters match, append the character to the result.
                if (arr[0].charAt(i) == arr[size - 1].charAt(i)) {
                    res.append(arr[0].charAt(i));
                }
                // Else, stop the comparison.
                else {
                    break;
                }
            }
            result = res.toString();
            System.out.println("Longest common prefix: " + result);

        }
        return result;
    }

    public static void main(String[] args) {

        String[] strs = { "flower", "flow", "flight" };
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

}
