package PepLevelUp.DP;

import java.util.ArrayList;

public class Rough {

    private static void PrintPermutations(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String leftStr = str.substring(0, i);
            String rightStr = str.substring(i + 1);
            PrintPermutations(leftStr + rightStr, asf + c);
        }

    }

    private static void PrintSubsequence(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        char c = str.charAt(0);
        String subStr = str.substring(1);
        PrintSubsequence(subStr, asf); // aayega ya nahi aayega
        PrintSubsequence(subStr, asf + c);

    }

    public static void main(String[] args) {

        String s = "abc";
        // PrintPermutations(s, "");

        PrintSubsequence(s, "");
    }

}
