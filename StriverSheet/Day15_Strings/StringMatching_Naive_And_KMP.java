package StriverSheet.Day15_Strings;

import java.util.ArrayList;

// Problem: Given a text of length N txt[0..N-1] and a pattern of length M pat[0..M-1], write a 
// function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].

// Approach 1: https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/  (Naive approach)
// Time Complexity- The number of comparisons in the worst case is O(M * (N – M + 1))

//  The KMP matching algorithm(Approach 2 below) improves the worst case to O(N)

// Approach 2 (KMP Algo):

// KMP Algo Appraoch (Not code) https://www.youtube.com/watch?v=V5-7GzOfADQ  (Listen from 7:00 mins)
// Idea is that if Begining part of the string is appearing again somewhere else in the string(in the 'pattern' to be found) then
// dont again compare the characters, avoid the comparison. Another thing is to 'not move back' like we were doing in the Naive approach

// Time Complexity : O(M+N)
// where N is the length of the string
// M is the length of the pattern

// KMP Algo code: https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/ 

public class StringMatching_Naive_And_KMP {

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

    static boolean StringSearch_Approach2(String pat, String txt) {
        int n = txt.length(), prevLPS = 0, i = 1;
        int[] lps = new int[n];
        while (i < n) {
            if (txt.charAt(i) == txt.charAt(prevLPS)) {
                lps[i++] = ++prevLPS;
            } else if (prevLPS == 0) {
                lps[i++] = 0;
            } else {
                prevLPS = lps[prevLPS - 1];
            }
        }
        return lps[n - 1] > 0 && n % (n - lps[n - 1]) == 0;
    }

    public static void main(String[] args) {
        String pat = "AABAACAADAABAAABAA";
        String txt = "AABA";

        // int[] result = StringSearch_Approach1(pat, txt); // approach 1
        StringSearch_Approach2(pat, txt);
        // int[] result = StringSearch_Approach2(pat, txt); // approach 2
        // for (int i : result) {
        // System.out.println(i + ", ");
        // }
    }

}
