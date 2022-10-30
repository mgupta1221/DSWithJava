package RecursionAndBacktracking.IntroToRecursion;

public class Test {

    public static int[] toh(int[] arr, int idx, int data, int foundSofar) {

        if (idx == arr.length)
            return new int[foundSofar];

        if (arr[idx] == data)
            foundSofar++;

        int[] tempResult = toh(arr, idx + 1, data, foundSofar);
        if (arr[idx] == data)
            tempResult[--foundSofar] = idx;

        return tempResult;

    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 9, 8, 7, 3, 4, 12, 7, 3, 8 };
        int[] result = toh(arr, 0, 8, 0);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
