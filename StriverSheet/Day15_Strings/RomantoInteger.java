package StriverSheet.Day15_Strings;

import java.util.HashMap;

public class RomantoInteger {

    // Problem: LC 13 https://leetcode.com/problems/roman-to-integer/

    public static int romanToInt(String str) {

        int result = 0;
        char[] chars = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < chars.length; i++) {

            if (i < chars.length - 1 && chars[i] == 'I' && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                result += chars[i + 1] == 'V' ? 4 : 9;
                i++;
            } else if (i < chars.length - 1 && chars[i] == 'X' && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                result += chars[i + 1] == 'L' ? 40 : 90;
                i++;
            } else if (i < chars.length - 1 && chars[i] == 'C' && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                result += chars[i + 1] == 'D' ? 400 : 900;
                i++;
            } else {
                // System.out.println(chars[i]);
                // System.out.println(map.get(chars[i]));
                result += map.get(chars[i]);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        String str = "MCMXCIV";
        int result = romanToInt(str);
        System.out.println(result);
    }

}
