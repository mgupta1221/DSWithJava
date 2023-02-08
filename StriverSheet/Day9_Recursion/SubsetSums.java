package StriverSheet.Day9_Recursion;

import java.util.ArrayList;

// Problem: https://practice.geeksforgeeks.org/problems/subset-sums2234/1

// Given a list arr of N integers, print sums of all subsets in it.
// N = 2, arr[] = {2, 3}
// Output:
// 0 2 3 5

// Explanation:
// When no elements is taken then Sum = 0.
// When only 2 is taken then Sum = 2.
// When only 3 is taken then Sum = 3.
// When element 2 and 3 are taken then Sum = 2+3 = 5.

public class SubsetSums {

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> result = new ArrayList<>();
        subsetSumsHelper(arr, N, 0, 0, result);
        return result;
    }

    public static void subsetSumsHelper(ArrayList<Integer> arr, int N, int idx, int currentSum,
            ArrayList<Integer> result) {
        if (idx == N) {

            result.add(currentSum);
            return;
        }

        subsetSumsHelper(arr, N, idx + 1, currentSum, result);
        subsetSumsHelper(arr, N, idx + 1, currentSum + arr.get(idx), result);

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);

        ArrayList<Integer> result = subsetSums(arr, 2);

        System.out.println(result);
    }
}
