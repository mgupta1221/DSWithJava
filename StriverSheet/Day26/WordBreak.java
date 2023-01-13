package StriverSheet.Day26;

import java.util.ArrayList;
import java.util.HashSet;

// Problem: https://practice.geeksforgeeks.org/problems/word-break1352/1
// Problem Statement: Given a string A and a dictionary of n words B, find out if
//  A can be segmented into a space-separated sequence of dictionary words.
// Note: From the dictionary B each word can be taken any number of times and in any order.

public class WordBreak {
    public static int wordBreak(String A, ArrayList<String> B) {
        HashSet<String> map = new HashSet<>();
        for (String str : B) {
            map.add(str);
        }

        return wordBreak_helper(A, map);

    }

    public static int wordBreak_helper(String A, HashSet<String> map) {
        int size = A.length();
        if (size == 0) {
            return 1;
        }

        for (int i = 1; i <= size; i++) {
            String str = A.substring(0, i);

            if (map.contains(str)) {
                String ros = A.substring(i, size);
                if (wordBreak_helper(ros, map) == 1) {
                    return 1;
                }

            }

        }
        return 0;

    }

    public static void main(String[] args) {
        int n = 12;
        // String A = "ilikesamsung";
        // ArrayList<String> B = new ArrayList<>();
        // B.add("i");
        // B.add("like");
        // B.add("sam");
        // B.add("sung");
        // B.add("samsung");
        // B.add("mobile");
        // B.add("ice");
        // B.add("cream");
        // B.add("icecream");
        // B.add("man");
        // B.add("go");
        // B.add("mango");

        // String A = "oobpplekgruowzlwphapjnaiqhdcnvwdtxkgruowzqhdcnvwdtxlwphapjna";
        // ArrayList<String> B = new ArrayList<>();
        // B.add("bbipzzrzu");
        // B.add("xamludf");
        // B.add("kgruowz");
        // B.add("i");
        // B.add("oobpple");
        // B.add("lwphapjna");
        // B.add("qhdcnvwdtx");

        String A = "qycjcdlgappppbmcxppbpbmcxppqycjcdlga";
        ArrayList<String> B = new ArrayList<>();
        B.add("b");
        B.add("qycjcdlga");
        B.add("pbmcx");
        B.add("p");

        int result = wordBreak(A, B);
        System.out.println(result);

    }
}
