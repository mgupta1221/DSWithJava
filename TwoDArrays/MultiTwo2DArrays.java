package TwoDArrays;

import java.util.Scanner;

public class MultiTwo2DArrays {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];

        // Taking Input for first array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int p = scn.nextInt();
        int q = scn.nextInt();
        int[][] arr2 = new int[p][q];

        // Taking Input for second array
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                arr2[i][j] = scn.nextInt();
            }
        }

        int[][] result = new int[m][q];
        // Multiplication done here, 3 loops
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                for (int j2 = 0; j2 < n; j2++) {
                    result[i][j] += arr[i][j2] * arr2[j2][j];
                }
            }
        }

        // Printing the result
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
