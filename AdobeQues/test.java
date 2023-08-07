package AdobeQues;

import StriverSheet.Day6.Node;

public class test {

    public static int findPlatform(int arr[], int dep[], int n) {

        int count = 0;

        for (int i = 1; i < dep.length; i++) {
            if (arr[i] > dep[i - 1]) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {

        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

        // int[] arr = { 900, 1100, 1235 };
        // int[] dep = { 1000, 1200, 1240 };
        int result = findPlatform(arr, dep, arr.length);
        System.out.println(result);
    }

}
