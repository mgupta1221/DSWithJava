package StriverSheet.Day15_Strings;

import java.util.HashMap;

public class IntegerToRoman {

    // Problem: LC 12 https://leetcode.com/problems/integer-to-roman/

    // Solved with 2 approaches below:
    //
    public static String IntToRoman_approach1(int num) {

        int result = 0;
        // Added below for reference
        // HashMap<Character, Integer> map = new HashMap<>();
        // map.put('I', 1);
        // map.put('V', 5);
        // map.put('X', 10);
        // map.put('L', 50);
        // map.put('C', 100);
        // map.put('D', 500);
        // map.put('M', 1000);

        // Basically we are adding following values in Roman :
        // 1,2,3,4,5...9 in array 'I'
        // 10, 20, 30, 40...90 in array 'X'
        // 100,200, 300 in array 'C' and likewise for array M
        String[] M = { "", "M", "MM", "MMM" };
        String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

        return M[(num) / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];

    }

    public static String IntToRoman_approach2(int num) {
        String result = "";

        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 10, 9, 5, 4, 1 };
        String[] valueChars = { "M", "CM", "D", "CD", "C", "XC", "L", "X", "IX", "V", "IV", "I" };
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result += valueChars[i];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int num = 1994;

        // String result = IntToRoman_approach1(num);

        String result = IntToRoman_approach2(num);
        System.out.println(result);
    }

}
