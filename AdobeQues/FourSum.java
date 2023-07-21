package AdobeQues;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num1 = arr[i];
            for (int j = i + 1; j < n; j++) {
                int num2 = arr[j];

                int l = j + 1;
                int m = arr.length - 1;

                while (l < m) {
                    int currentSum = num1 + num2 + arr[l] + arr[m];
                    if (currentSum == k) {
                        ArrayList<Integer> subResult = new ArrayList<>();
                        subResult.add(num1);
                        subResult.add(num2);
                        subResult.add(arr[l]);
                        subResult.add(arr[m]);
                        result.add(subResult);
                        l++;

                        while (l < m && arr[l] == arr[l - 1]) {
                            l++;
                        }

                        m--;
                        while (l < m && arr[m] == arr[m + 1]) {
                            m--;
                        }
                    }
                    if (currentSum < k) {
                        l++;
                        while (l < m && arr[l] == arr[l - 1]) {
                            l++;
                        }
                    }
                    if (currentSum > k) {
                        m--;
                        while (l < m && arr[m] == arr[m + 1]) {
                            m--;
                        }
                    }
                }

                while (j < arr.length - 1 && arr[j] == arr[j + 1]) {
                    j++;
                }
            }
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, 3, 4, 5, 7, 8 };
        int k = 23;
        ArrayList<ArrayList<Integer>> result = fourSum(arr, k);
        for (ArrayList<Integer> arrayList : result) {
            for (Integer num : arrayList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

}
