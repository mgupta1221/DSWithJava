package StriverSheet.Day16_StringII;

import java.util.HashMap;
import java.util.Set;

public class ValidAnagrams {

    // Problem LC 242: https://leetcode.com/problems/valid-anagram/

    // 4 approaches:
    // https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/

    // Approach 1: There are total 256 charcters on keyboard , create 1 array each
    // for both
    // strings with size 256. Store the count of each charcter
    // in respective array. At the end match the count of each character. If counts
    // are same than they are analgram, else not.
    // Time Complexity: O(n)
    // Auxiliary Space: O(256) i.e. O(1) for constant space.

    // Approach 2: Using 1 count array, instead of 2 in approach 1

    // Approach 3: Using HashMap

    public static boolean isAnagram_appraoch1(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count1 = new int[256];
        int[] count2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int asciiVal = (int) s.charAt(i);
            count1[asciiVal]++;

            asciiVal = (int) t.charAt(i);
            count2[asciiVal]++;
        }

        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i])
                return false;
        }
        return true;
    }

    public static boolean isAnagram_appraoch2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count1 = new int[256];

        // for (int i = 0; i < s.length(); i++) {
        // int asciiVal = (int) s.charAt(i);
        // count1[asciiVal]++;

        // }
        // for (int i = 0; i < t.length(); i++) {
        // int asciiVal = (int) t.charAt(i);
        // count1[asciiVal]--;

        // This one can be done in 1 loop as shown below:
        for (int i = 0; i < s.length(); i++) {
            int asciiVal = (int) s.charAt(i);// charcter from s
            count1[asciiVal]++;

            asciiVal = (int) t.charAt(i);// character from t
            count1[asciiVal]--;
        }

        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != 0)
                return false;
        }
        return true;
    }

    public static boolean isAnagram_appraoch3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }

        // Very important: HashMap cannot be iterated over index like Strings and Arrays
        // Below is the way to iterate through HashMap via keySet
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String str1 = "gram";
        String str2 = "grma";

        // Function call
        // System.out.println(isAnagram_appraoch1(str1, str2));
        // System.out.println(isAnagram_appraoch2(str1, str2));
        System.out.println(isAnagram_appraoch3(str1, str2));

    }

}
