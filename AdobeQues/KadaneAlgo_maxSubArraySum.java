package AdobeQues;

public class KadaneAlgo_maxSubArraySum {

    // Kadane's Algo O(n)
    public static long maxSumSubArray(int[] arr) {
        long maxSumTillhere = arr[0];
        long sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // notice the comparison with arr[i] not maxSumTillHere
            if (maxSumTillhere + arr[i] > arr[i]) {
                maxSumTillhere = maxSumTillhere + arr[i];
            } else {
                maxSumTillhere = arr[i];
            }
            sum = Math.max(sum, maxSumTillhere);
        }
        return sum;
    }

    public static void main(String[] args) {

        int nums[] = { -1, -2, -3, -3, -2 };

        long result_maxSum = maxSumSubArray(nums);
        System.out.println("MaxSum: " + result_maxSum);

    }
}
