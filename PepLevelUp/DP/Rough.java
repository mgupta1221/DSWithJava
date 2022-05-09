package PepLevelUp.DP;

import java.util.ArrayList;

public class Rough {

    private static int DeleteOperationOfStrings(String str1, String str2, int m, int n) {

        return 1;

    }

    private static ArrayList<String> GetSubsequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        char firstChar = str.charAt(0);
        String restOfString = str.substring(1);

        ArrayList<String> rros = GetSubsequence(restOfString);
        ArrayList<String> interimResult = new ArrayList<>();
        for (String rroStr : rros) {
            interimResult.add(firstChar + rroStr);
            interimResult.add(rroStr + "");

        }
        return interimResult;

    }

    private static void PrintPermutations(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char firstChar = str.charAt(i);// a
            String ros = str.substring(0, i) + str.substring(i + 1);// bc
            PrintPermutations(ros, firstChar + asf);
        }

    }

    public static void main(String[] args) {

        // String str = "rabbbit";
        // ArrayList<String> result = GetSubsequence(str);
        // System.out.println(result);

        String str = "abc";
        PrintPermutations(str, "");

    }

}
