package StriverSheet.Day11_BinarySearch;

// https://www.geeksforgeeks.org/n-th-root-number/

// Approach: In cases : When if we increase input, output also increases than we can use Binary Search Approach.
// To use Bnary search, we have to define range(in between which our answer will lie somewhere) in
// order to get 'low' and 'high'values to start with.

// In this case, Range will be between 1 till 'm' between which our answer will lie.

public class NthRootOfInteger {

    public static int NthRoot(int n, int m) {
        return NthRootHelper(n, m, 1, m);

    }

    private static int NthRootHelper(int n, int m, int low, int high) {
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            double result = Math.pow(mid, n);
            if (result == m) {
                return mid;
            } else if (result < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        // int n = 5, m = 243;
        int n = 6, m = 4096;
        int result = NthRoot(n, m);
        System.out.println(result);
    }

}
