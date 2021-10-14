package RecursionAndBacktracking.RecursionWithArrays;

// https://www.youtube.com/watch?v=XpUiZg9YZQg

public class FindMaxInArray {
    public static void main(String[] args) {
        int[] arr = { 8, -23, -15, 7, -19 };

        int maxNo = FindMax(arr, 0);
        System.out.println("Max is: " + maxNo);

    }

    public static int FindMax(int[] arr, int idx) {
        //base condition
        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }

        int max = FindMax(arr, idx + 1); // recursive call
        if (max < arr[idx]) {
            max = arr[idx];
        }
        return max;

    }

}
