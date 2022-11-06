package StriverSheet.Day9_Recursion;

import java.util.ArrayList;

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
