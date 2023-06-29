package AdobeQues;

public class CountInversions {

    // Problem: https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?page=1&difficulty[]=1&company[]=Adobe&sortBy=submissions

    public static long inversionCount(long arr[], long N) {
        return mergeSort(arr, 0, (int) N - 1);
    }

    public static long mergeSort(long[] arr, int low, int high) {

        long count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    public static long merge(long[] arr, int low, int mid, int high) {

        long[] mergedArr = new long[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        long count = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                mergedArr[k++] = arr[i++];

            } else {
                mergedArr[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            mergedArr[k++] = arr[i++];
        }
        while (j <= high) {
            mergedArr[k++] = arr[j++];
        }

        for (int m = 0, n = low; m < mergedArr.length; m++, n++) {
            arr[n] = mergedArr[m];
        }
        return count;

    }

    public static void main(String[] args) {

        // long[] A = { 2, 4, 1, 3, 5 }; // Output 3

        long[] A = { 468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392,
                105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312,
                323 }; // Output 494

        long result = inversionCount(A, A.length);

        System.out.print(result + " ");

    }

}
