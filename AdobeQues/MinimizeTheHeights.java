package AdobeQues;


import java.util.Arrays;

public class MinimizeTheHeights {

    // Problem:
    // https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
    // New

    // Approach Explanation: https://www.youtube.com/watch?v=Av7vSnPSCtw
   //  https://www.youtube.com/watch?v=tSLiZAQG9NM

    // Explnsation on code:
    // 1. We sorted the array first becuase minimum differnece can only be found from consecutive elements

    // 2. After sorting, I have to maximize the (i-1)th element and have to minimize the (i)th element, see inside for loop

    // 3. 'if' condition in loop  is added so that if 'min' is negative, the difference max-min will increase and we dont want that

    // 4. Loop starts with 1 instead of 0, becuase we have to ignore arr[0] from
    // 'min' computation and arr[n-1] has to be ignored for 'max' computation


    public static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int result = arr[n - 1] - arr[0]; //if k=0 than this will be our answer
        int largest = arr[n - 1] - k;
        int smallest = arr[0] + k;

        int max, min;
        
        for (int i = 1; i < arr.length; i++) {

            max = Math.max(arr[i - 1] + k, largest); // i runs from 0 to (n-2), skipping last element
            min = Math.min(arr[i] - k, smallest); // i runs from 1 to (n-1), skipping first element

            if (min < 0) // becuase if we do (max-min) and 'min' is negative, than the value will effectively increase.
                continue;

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
