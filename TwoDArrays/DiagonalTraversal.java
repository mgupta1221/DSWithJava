package TwoDArrays;

import java.util.Scanner;

public class DiagonalTraversal {
    public static void main(String[] args) {
        // Taking automated hardcoded Input
        int m = 4;
        int n = 4;

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

        // Printing the matrix first
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0, j = i; j < arr.length; k++, j++) { // 01 12 ..... 02 13 24
                System.out.print(arr[k][j] + "\t");
            }
        }

    }
}
