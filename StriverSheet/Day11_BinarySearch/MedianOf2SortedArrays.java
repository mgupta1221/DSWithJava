package StriverSheet.Day11_BinarySearch;

public class MedianOf2SortedArrays {

    // Approach : https://www.youtube.com/watch?v=yD7wV8SyPrc
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // When length are different then apply binary search on shortest array to avoid
        // index out of bound
        if (nums1.length > nums2.length) {
            return (findMedianSortedArrays(nums2, nums1));
        }
        int low = 0;
        int high = nums1.length;

        int n1 = nums1.length;
        int n2 = nums2.length;

        while (low <= high) {
            // Initialize the cuts or partitions
            int cut1 = (low + high) / 2; // notice cut1 is index value, not actual in nums array

            // Total required - already present
            int cut2 = ((n1 + n2) / 2) - cut1; // // notice cut2 is index value, not actual in nums array

            // Initialize l1,l2,r1,r2
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            // this below condition should hold true to find the media..remember this
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2; // Notice type-casting else it will
                                                                               // return 2.0 instead of 2.5
                } else {
                    // return Math.max(l1, l2); // will not work
                    return (double) Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int arr1[] = { 1, 4, 7, 10, 12 };
        // int arr2[] = { 2, 3, 6, 15 };

        int arr1[] = { 1, 2 };
        int arr2[] = { 3, 4 };

        double result = findMedianSortedArrays(arr1, arr2);

        System.out.println(result);

    }
}
