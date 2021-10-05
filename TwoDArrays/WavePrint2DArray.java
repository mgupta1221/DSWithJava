package TwoDArrays;

import java.util.Scanner;

//Wave travesal of 2D array
// https://www.youtube.com/watch?v=_olQ9Rrnm_c


public class WavePrint2DArray {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];

        // Taking Input
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        // Printing the result

        for (int i = 0; i < n; i++) { // Notice we are running the outer loop n times, NOT m times
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    System.out.println(arr[j][i]);  //Also notice we are keeping j and i
                }
            }
            if (i % 2 == 1) {
                for (int j = m - 1; j >= 0; j--) {
                    System.out.println(arr[j][i]);
                }
            }
            System.out.print("");
        }

    }
}
