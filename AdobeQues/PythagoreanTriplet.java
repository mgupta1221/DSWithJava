package AdobeQues;

import java.util.Arrays;

// Pythagorean Triplet  (find a^2+b^2=c^2)
// New

// Problem:  https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1

// Approach 1: Bruteforce

// Approach 2: 
//  i)  Do the square of every element in the input array. This step takes O(n) time.
// ii)  Sort the squared array in increasing order. This step takes O(nLogn) time.

// iii) Now the problem became 3-Sum problem type (a2=b2+c2) i.e. Fix ‘a’ as the last element of the sorted array.
// Now search for pair (b, c) in subarray between the first element and ‘a’. 

public class PythagoreanTriplet {

    // Approach 1: Naive approach
    static boolean checkTriplet(int[] arr, int n) {
        int x, y, z;
        for (int i = 0; i < arr.length; i++) {
            x = arr[i] * arr[i];
            for (int j = i; j < arr.length; j++) {
                y = arr[j] * arr[j];
                for (int k = j; k < arr.length; k++) {
                    z = arr[k] * arr[k];
                    if (x + y == z) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Approach 2: Optimised approach
    static boolean checkTriplet_optimized(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            int num1 = arr[i];
            int m1 = 0;
            int n1 = i - 1;

            while (m1 < n1) {
                if (num1 == arr[m1] + arr[n1]) {
                    return true;
                }
                if (num1 > arr[m1] + arr[n1]) {
                    m1++;
                } else {
                    n1--;
                }
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int[] A = { 3, 2, 4, 6, 5 };
        // boolean result = checkTriplet(A, A.length);
        boolean result = checkTriplet_optimized(A, A.length);
        System.out.println(result);
    }
}
