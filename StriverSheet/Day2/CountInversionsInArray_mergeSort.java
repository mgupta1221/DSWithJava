package StriverSheet.Day2;

public class CountInversionsInArray_mergeSort {

    // Problem :
    // https://www.codingninjas.com/codestudio/problems/count-inversions_615
    // For a given integer array/list 'ARR' of size 'N' containing all distinct
    // values, find the total number of 'Inversions' that may exist.

    // An inversion is defined for a pair of integers in the array/list when the
    // following two conditions are met::

    // A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:
    // 1. 'ARR[i] > 'ARR[j]'
    // 2. 'i' < 'j'
    // Where 'i' and 'j' denote the indices ranging from [0, 'N'].

    // Below is the Recursive function which will split array recursively and later
    // merge the array in a sorted form

    // https://www.youtube.com/watch?v=owZhw-A0yWE&t=628s
    public static int mergeSort(int[] nums, int low, int high) {
        int inversionCount = 0;
        if (low < high) { // 'if' not 'while'
            int mid = (low + high) / 2;
            inversionCount += mergeSort(nums, low, mid);
            inversionCount += mergeSort(nums, mid + 1, high);
            inversionCount += merge(nums, low, mid, high);
        }
        return inversionCount;

    }

    public static int merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] mergedArr = new int[end - start + 1];

        int inversionCount = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                mergedArr[k] = nums[i];
                i++;
                k++;
            } else {
                mergedArr[k] = nums[j];
                j++;
                k++;
                inversionCount = inversionCount + (mid - i + 1); // statement added for getting inversion.
                // mid-i+1 , becuase we have to pick all elements to the right of the current
                // element in the left array, and 'mid' is the last element of the first array
                // and 'i' is the current index so total elements = mid-i+1
            }
        }
        while (i <= mid) {
            mergedArr[k] = nums[i];
            i++;
            k++;
        }
        while (j <= end) {
            mergedArr[k] = nums[j];
            j++;
            k++;
        }

        for (int l = 0, j1 = start; l < mergedArr.length; l++, j1++) {
            nums[j1] = mergedArr[l];
        }
        return inversionCount; // returning count

    }

    public static void main(String[] args) {

        int[] nums = { 5, 3, 2, 1, 4 }; // Inversions 7
        int count = mergeSort(nums, 0, nums.length - 1);

        System.out.print("Total inversions:  " + count);

    }

}
