package StriverSheet.Day4;

import java.util.Arrays;

// https://leetcode.com/problems/h-index/

// Solution: https://www.youtube.com/watch?v=CjKJDloMnwE  (See from 4:08)

// Approach uses Sorting (nLogn) and Binary Search(logN)
public class hIndex {

    public static int hIndex(int[] citations) {

        int n = citations.length;
        Arrays.sort(citations);

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (citations[mid] == n - mid) {
                return citations[mid];
            } else if (citations[mid] > n - mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return n - low; // this is explained at 17:00 in solution video

    }

    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 }; // ans :3
        int result = hIndex(citations);
        System.out.println(result);

    }
}
