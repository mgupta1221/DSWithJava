package StriverSheet.Day16_StringII;

// Problem: https://www.codingninjas.com/codestudio/problems/1112619

// You’re given a string S of length N and a string P of length M. Your task is to find the number of occurrences of P in S in linear time.
// If S = "ababa", and P = "ab", then "ab" occurs twice in "ababa".

public class Z_Function {

    public static int strStr(String haystack, String needle) {

        int hLength = haystack.length();
        int nLength = needle.length();

        int count = 0;

        for (int i = 0; i <= hLength - nLength; i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // String haystack = "hello";
        // String needle = "ll";

        String haystack = "a";
        String needle = "a";

        int result = strStr(haystack, needle);
        System.out.println(result);
    }

}
