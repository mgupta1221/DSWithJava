package Blind75.Arrays;

import java.util.HashMap;

public class ValidAnagrams242 {

    public static boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        if (slen != tlen) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }

        for (Character ch : map.keySet()) {
            if (map.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = ValidAnagrams242.isAnagram(s, t);
        System.out.println(result);
    }

}
