package TwoDArrays;

import java.util.Scanner;

// Rotate by 90 Degree - Square 2d ARRAY
// https://www.youtube.com/watch?v=SoxrXQbhCPI&list=RDCMUC7rNzgC2fEBVpb-q_acpsmw&start_radio=1&rv=SoxrXQbhCPI&t=650

//Solution: Rotatiting a 2D Array means - Making 1st row as last column, 2nd row and second last column...last row as first column

//To solve this. first transpose the matrix(make 1st row as 1st column, 2nd row as 2nd column...likewise)
//Then make 1st column the last column, 2nd column the second last column...etc

//Key thing to note- during Transpose only consider the upper diagonal half(else same numbers will be swapped twice)

// XXX                     XXX                                                                                       
// XXX                      XX                                                                                       
// XXX                       X     
//Transpose only this part(upper diagonal half) shown on the right above

public class RotateBy90Degree {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        // Taking Input for array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        // printing orignal matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        // transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) { // putting this conditon to only swap the elements once - considering diagonally
                              // upper half only for swapping
                    var temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }

        // printing transposed matrix
        System.out.println("transposed Matrix ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        // Now swapping first column with last, secnd with second last
        for (int i = 0; i < n; i++) {
            int j = 0;
            int k = arr.length - 1;
            while (j < k) { // Here also swapping might happen twice if we run from 0 to n hence we only process till j overldap k
                var temp = arr[i][j];
                arr[i][j] = arr[i][k];
                arr[i][k] = temp;
                j++;
                k--;
            }

        }

        System.out.println("Rotated Matrix 90 degree");

        // printing rotated matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
