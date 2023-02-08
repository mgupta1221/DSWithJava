package StriverSheet.Day9_Recursion;

import java.util.ArrayList;
import java.util.List;

// LC 131: https://leetcode.com/problems/palindrome-partitioning/

// See trick diagram:  PalindromePatitioning-Euler tree.webp

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> subResult = new ArrayList<>();

        partitionHelper(s, 0, subResult, result);
        return result;

    }

    public static void partitionHelper(String s, int idx, List<String> subResult, List<List<String>> result) {

        if (idx == s.length()) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPallendrome(s, idx, i)) {
                subResult.add(s.substring(idx, i + 1));
                partitionHelper(s, i + 1, subResult, result); // In permutuation quention, it is (idx+1), check the
                                                              // difference by making (i+1) to (idx+1)

                subResult.remove(subResult.size() - 1);
            }
        }
    }

    public static boolean isPallendrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            } else {

                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);

        for (int i = 0; i < result.size(); i++) {

            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
