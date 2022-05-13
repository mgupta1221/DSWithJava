package PepLevelUp.DP;

// Problem and solution

//https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/

// Similar problem:
//https://www.geeksforgeeks.org/minimum-number-deletions-make-sorted-sequence/

// Thi follows the pattern of "LCS"

// An efficient approach uses the concept of finding the length of the longest common subsequence of the given two sequences.

// Algorithm: 

// str1 and str2 be the given strings.
// m and n be their lengths respectively.
// len be the length of the longest common subsequence of str1 and str2
// minimum number of deletions minDel = m – len
// minimum number of Insertions minInsert = n – len
public class Count_MinInsertionDeletionToConvert {

    public static int GetLCS(char[] char1, char[] char2, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (char1[m - 1] == char2[n - 1]) {
            return GetLCS(char1, char2, m - 1, n - 1) + 1;
        }
        int x = GetLCS(char1, char2, m - 1, n);
        int y = GetLCS(char1, char2, m, n - 1);

        return Math.max(x, y);

    }

    public static void main(String[] args) {
        String str1 = "heap";
        String str2 = "pea";

        // Getting LCS- Longest common Subsequnce
        int len = GetLCS(str1.toCharArray(), str2.toCharArray(),
                str1.length(), str2.length());

        System.out.print("Minimum number of "
                + "deletions = ");
        System.out.println(str1.length() - len);

        System.out.print("Minimum number of "
                + "insertions = ");
        System.out.println(str2.length() - len);

    }

}
