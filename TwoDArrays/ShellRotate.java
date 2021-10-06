package TwoDArrays;

import java.util.Scanner;

// Shell Rotate

//Solution Video:  https://www.youtube.com/watch?v=atMK9aA-s7Y

//Solution:  3 Steps as below
// 1. Pull the required shell into a 1-D array
// 2. Rotate the array
// 3. Push the transformed array back into the shell

public class ShellRotate {
    public static void main(String[] args) {

        // Taking automated hardcoded Input
        int m = 4;
        int n = 4;
        int shellNumber = 2;
        int rotationsRequired = 1;

        var str = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36";
        String[] elementsInArrayFormat = str.split(" ");
        int[][] arr = new int[m][n];
        int conter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(elementsInArrayFormat[conter]);
                conter++;
            }
        }
        display(arr);
        System.out.println();
        rotateShell(arr, shellNumber, rotationsRequired);
        display(arr);
    }

    // Helper function to rotate
    public static void rotateShell(int[][] arr, int shellNumber, int rotationsRequired) {
        int[] OneDArray = fillOneDArrayFromShell(arr, shellNumber); //Step 1 
        rotate(OneDArray, rotationsRequired); //Step 2
        fillShellFromOneDArray(arr, shellNumber, OneDArray); //Step 3
    }

    public static int[] fillOneDArrayFromShell(int[][] arr, int shellNumber) {

        int minR = shellNumber - 1; // E.g. if shell is 2 than starting index becomes 1,1
        int minC = shellNumber - 1;
        int maxR = arr.length - shellNumber;
        int maxC = arr[0].length - shellNumber;
        int OneDArraySize = 2 * (maxR - minR + 1) + 2 * (maxC - minC + 1) - 4;
        int[] OneDArray = new int[OneDArraySize];

        int counter = 0;

        // Left Wall
        for (int i = minR, j = minC; i <= maxR; i++) {
            OneDArray[counter] = arr[i][j];
            counter++;
        }

        // Bottom Wall
        for (int i = maxR, j = minC + 1; j <= maxC; j++) { // Notice we are starting j with minC+1 to void duplictae
                                                           // corners
            OneDArray[counter] = arr[i][j];
            counter++;
        }

        // Right Wall
        for (int i = maxR - 1, j = maxC; i >= minR; i--) {
            OneDArray[counter] = arr[i][j];
            counter++;
        }

        // Top Wall
        for (int i = minR, j = maxC - 1; j >= minC + 1; j--) {
            OneDArray[counter] = arr[i][j];
            counter++;
        }
        return OneDArray;

    }

    public static void rotate(int[] arr, int rotationsRequired) {

        // rotating first part
        int low = 0;
        int high = arr.length - rotationsRequired - 1;
        while (low < high) {
            int temp1 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp1;
            low++;
            high--;
        }
        // rotating second part
        low = arr.length - rotationsRequired;
        high = arr.length - 1;
        while (low < high) {
            int temp1 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp1;
            low++;
            high--;
        }

        // rotating full array now
        low = 0;
        high = arr.length - 1;
        while (low < high) {
            int temp1 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp1;
            low++;
            high--;
        }

    }

    public static void fillShellFromOneDArray(int[][] arr, int shellNumber, int[] OneDArray) {
        int minR = shellNumber - 1; // E.g. if shell is 2 than starting index becomes 1,1
        int minC = shellNumber - 1;
        int maxR = arr.length - shellNumber;
        int maxC = arr[0].length - shellNumber;

        int counter = 0;

        // Left Wall
        for (int i = minR, j = minC; i <= maxR; i++) {
            arr[i][j] = OneDArray[counter];
            counter++;
        }

        // Bottom Wall
        for (int i = maxR, j = minC + 1; j <= maxC; j++) { // Notice we are starting j with minC+1 to void duplictae
                                                           // corners
            arr[i][j] = OneDArray[counter];
            counter++;
        }

        // Right Wall
        for (int i = maxR - 1, j = maxC; i >= minR; i--) {
            arr[i][j] = OneDArray[counter];
            counter++;
        }

        // Top Wall
        for (int i = minR, j = maxC - 1; j >= minC + 1; j--) {
            arr[i][j] = OneDArray[counter];
            counter++;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
