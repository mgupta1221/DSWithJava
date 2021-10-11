package TestQuestions;

import java.util.Scanner;
// Diagonal_and_Wave_Traversal
// https://www.hackerrank.com/contests/test-3-1633882344/challenges/diagonal-and-wave-traversal

// 10 11 12 13
// 20 21 22 23
// 30 31 32 33
// 40 41 42 43

// O/P: 40 41 30 20 31 42 43 32 21 10 11 22 33 23 12 13 

//Solution video
// https://www.youtube.com/watch?v=LWRR7h44VcY

//Idea is if sum of i and j is odd than we are going "downwards" and if sum is even than we are going upwards

public class Test1Q2 {

    public static void main(String[] args) {
        // Taking automated hardcoded Input
        // int m = 4;
        // int n = 4;

        Scanner scn = new Scanner(System.in);
       

        int n =Integer.parseInt( scn.nextLine());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {            
            String str = scn.nextLine();
            String[] temp = str.split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(temp[j]);

            }

        }
        


        int m = n;

        printMatrix(a);
        System.out.println();

        // Solution starts here
        // Temp variables to denote row and column of cell
        int row = m - 1;
        int col = 0;

        for (int i = 1; i <= m * n; i++) {
            System.out.print(a[row][col] + "\t");

            if ((row + col) % 2 == 0) {
                if (row == 0) { // Notice if row+col is Even than check only if row = 0 (not col =0), Basically
                                // boundary conditions are differnet when row+col is even or when they are odd
                    col++;
                } else if (col == 0) {
                    row--;
                } else {
                    row--;
                    col--;
                }
            } else {
                if (row == n - 1) {
                    col++;
                } else if (col == n - 1) {
                    row--;
                } else {
                    row++;
                    col++;
                }
            }

        }

    }

    public static void printMatrix(int[][] arr) {
        // printing orignal matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
