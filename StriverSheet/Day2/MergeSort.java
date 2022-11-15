package StriverSheet.Day2;

public class MergeSort {

    // Recursive function which will split array recursively and later merge the
    // array in a sorted form
    public static void mergeSort(int[] nums, int low, int high) {

        if (low < high) { // 'if' not 'while' else it will be infinite loop --- IMPORTANT
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }

    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] mergedArr = new int[end - start + 1];

        while (i <= mid && j <= end) { // i is less than mid and j is less than end
            if (nums[i] <= nums[j]) {
                mergedArr[k] = nums[i];
                i++;
                k++;
            } else {
                mergedArr[k] = nums[j];
                j++;
                k++;
            }
        }
        while (i <= mid) { // filling remaining elements for i (of first array)
            mergedArr[k] = nums[i];
            i++;
            k++;
        }
        while (j <= end) { // filling remaining elements for j (of second array)
            mergedArr[k] = nums[j];
            j++;
            k++;
        }

        for (int l = 0, j1 = start; l < mergedArr.length; l++, j1++) {
            nums[j1] = mergedArr[l];
        }

    }

    public static void main(String[] args) {

        int[] nums = { 38, 27, 43, 3, 9, 82, 10 };
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
