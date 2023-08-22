package AdobeQues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MostFreqWordInStringArray {

    // https://practice.geeksforgeeks.org/problems/most-frequent-word-in-an-array-of-strings3528

    // Solution: First Get counts of each words in HashMap. Then follow apporach 1
    // or 2

    // Approach 1: Remove the value from hashmap after first consideration so that
    // its count is not considered again

    // Approach 2: Reduce the count of current Element by 1 it is of highest
    // occurnce so far

    public static String mostFrequentWord(String arr[], int n) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String str : arr) {
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        int lastHighest = 0;
        String ans = "";
        for (String str : arr) {
            int currentfreq = hm.getOrDefault(str, 0); // make sure to use getOrDefault() else it will break in Apporach
                                                       // 1

            if (currentfreq >= lastHighest) {
                lastHighest = currentfreq;
                // hm.put(str, hm.getOrDefault(str,0)-1);
                // Approach 2:, you can reduce the current element;s count in hashMap by
                // 1
                ans = str;
            }
            hm.remove(str); // Approach 1
        }

        return ans;

    }

    public static void main(String[] args) {
        String[] arr = { "geeks", "for", "geeks" };
        String res = mostFrequentWord(arr, arr.length);
        System.out.println(res);

    }
}
