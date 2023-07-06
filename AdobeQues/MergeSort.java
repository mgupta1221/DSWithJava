package AdobeQues;


public class MergeSort {
    // Solved ealier

    public static int[] mergeSort(int[] arr, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);

        }
        return arr;
    }

    public static void merge(int[] arr, int low, int mid, int high) {

        int[] mergedArr = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                mergedArr[k++] = arr[i++];
            } else {
                mergedArr[k++] = arr[j++];
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
        return;

    }

    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int[] result = mergeSort(arr, 0, arr.length - 1);

        for (int item : result) {
            System.out.print(item + " ");
        }

    }

}
