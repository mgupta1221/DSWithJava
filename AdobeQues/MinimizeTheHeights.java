package AdobeQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimizeTheHeights {

    // Problem:
    // https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
    // New

    // Approach Explanation: https://www.youtube.com/watch?v=tSLiZAQG9NM

    // Explnsation on code:
    // 1. Added below 'if' condition in loop because in the question it is a
    // condtion that after add/subtract, array value should not turn negative

    // 2. Loop starts with 1 instead of 0, becuase we have to ignore arr[0] from
    // 'min' computation and arr[n-1] has to be ignored for 'max' computation

    public static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int result = arr[n - 1] - arr[0];

        int largest = arr[n - 1] - k;
        int smallest = arr[0] + k;

        int max, min;
        // i==1
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - k < 0)
                continue;

            max = Math.max(arr[i - 1] + k, largest);
            min = Math.min(arr[i] - k, smallest);

            result = Math.min(result, max - min);
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 5, 8, 10 };
        int[] arr = { 2, 6, 3, 4, 7, 2, 10, 3, 2, 1 };

        int result = getMinDiff(arr, arr.length, 5);

        System.out.print(result + " ");

    }
}
