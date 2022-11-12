package StriverSheet.Day11_BinarySearch;

public class BinarySearch {

    public static int BinarySearch(int[] arr, int low, int high, int target) {

        if (low > high) {
            return -1;
        }
        int m = (low + high) / 2;
        if (target == arr[m]) {
            return m;
        } else if (target < arr[m]) {
            high = m - 1;
        } else {
            low = m + 1;
        }
        return BinarySearch(arr, low, high, target);

    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 50, 60, 80, 110, 130, 140, 170 };

        int result = BinarySearch(arr, 0, arr.length - 1, 110);
        System.out.println(result);
    }
}
