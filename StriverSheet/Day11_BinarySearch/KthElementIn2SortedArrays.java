package StriverSheet.Day11_BinarySearch;

public class KthElementIn2SortedArrays {

    // Solution below is NOT using Binary Search

    // https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/

    public static long kthElement(int arr1[], int arr2[], int n, int m, int k) {

        int len1 = arr1.length;
        int len2 = arr2.length;
        int arr1Idx = 0;
        int arr2Idx = 0;
        int counter = 0;
        int currentIdx = 1;

        while (arr1Idx < len1 && arr2Idx < len2) {
            System.out.print(arr1[arr1Idx] + " ");
            System.out.print(arr2[arr2Idx]);

            if (arr1[arr1Idx] < arr2[arr2Idx]) {
                arr1Idx++;
                currentIdx = 1;
            } else {
                arr2Idx++;
                currentIdx = 2;
            }
            counter++;
            System.out.print(" " + counter);

            System.out.println();
            if (counter == k) {
                if (currentIdx == 1) {
                    arr1Idx--;
                    return arr1[arr1Idx];
                } else {
                    arr2Idx--;
                    return arr2[arr2Idx];
                }

            }
        }
        if (arr1Idx < len1) {
            while (arr1Idx < len1) {
                if (counter == k) {
                    return arr1[--arr1Idx];
                }
                counter++;
                arr1Idx++;
            }
        }
        if (arr2Idx < len2) {
            while (arr2Idx < len2) {
                if (counter == k) {
                    return arr2[--arr2Idx];
                }
                counter++;
                arr2Idx++;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int arr1[] = { 100, 112, 256, 349, 770 };
        int arr2[] = { 72, 86, 113, 119, 265, 445, 892 };

        // int arr1[] = { 1, 10, 10, 25, 40, 54, 79 };
        // int arr2[] = { 15, 24, 27, 32, 33, 39, 48, 68, 82, 88, 90 };

        double result = kthElement(arr1, arr2, arr1.length, arr2.length, 7);

        System.out.println(result);
    }
}
