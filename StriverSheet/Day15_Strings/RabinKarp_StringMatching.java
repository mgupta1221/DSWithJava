package StriverSheet.Day15_Strings;

import java.util.ArrayList;

// Problem: Given a text of length N txt[0..N-1] and a pattern of length M pat[0..M-1], write a 
// function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].

// Approach 1: https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/
// Time Complexity- The number of comparisons in the worst case is O(M * (N – M + 1))


// Approach 2
// KMP Algo: https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/

public class RabinKarp_StringMatching {

    static int[] StringSearch_Approach1(String pat, String txt) {
        int l1 = pat.length();
        int l2 = txt.length();

        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < l1 - l2; i++) {

            String subStr = pat.substring(i, i + l2);
            if (subStr.equals(txt)) { // note we are using ".equals()" for string, instead of ==
                System.out.println("Occurnece at index " + i);
                indexes.add(i);
            }
        }

        int[] result = new int[indexes.size()];
        int i = 0;
        for (int index : indexes) {
            result[i++] = index;

        }
        return result;
    }

    public static void main(String[] args) {
        String pat = "AABAACAADAABAAABAA";
        String txt = "AABA";

        int[] result = StringSearch_Approach1(pat, txt);
        for (int i : result) {
            System.out.println(i + ", ");
        }
    }

}
