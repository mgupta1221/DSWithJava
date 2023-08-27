package AdobeQues;


// https://practice.geeksforgeeks.org/problems/next-higher-palindromic-number-using-the-same-set-of-digits5859/1

// This question is similar to NextPermutuation - check Striver folder -  Day 1 Arrays

public class NextHigherPalindromicNumber {

    public static String nextPalin(String s) {
        System.out.println(s);
        // complete the function here
        if (s.length() == 1 || s.length() == 2)
            return "-1";
        StringBuilder a = new StringBuilder();
        String x = s.substring(0, s.length() / 2);
        char[] arr = x.toCharArray();
        int i = 0;
        int y = 0;
        for (i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                y = i - 1;
                break;
            }
        }

        if (i == 0)
            return "-1";
        else {
            int j = arr.length - 1;
            while (j > i && arr[y] >= arr[j])
                j--;
            swap(arr, y, j);
            reverse(arr, i, arr.length - 1);
            for (i = 0; i < arr.length; i++) {
                a.append(arr[i]);
            }
            if (s.length() % 2 != 0)
                a.append(s.charAt(s.length() / 2));
            for (i = arr.length - 1; i >= 0; i--) {
                a.append(arr[i]);
            }
            return a.toString();
        }

    }

    public static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        String str = "19876567891";
        str = "2598952"; // 2958592
        String res = nextPalin(str);
        System.out.println(res);
    }

}
