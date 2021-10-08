package GettingStartedBasics.TwoDArrays;

import java.util.Scanner;

// Search in 2d ARRAY (Array is sorted by row and column both)

//Solution - https://www.youtube.com/watch?v=5vP0-g94xEA
//Solution Desc - Take top right corner of matrix and keep moving down(row++) till either you get the number or number is array 
// is smaller than number to be searched. When you encounter that number to be be searched is greater 
// than number in array- Move left (column-- )

public class SearchIn2DArray {
    public static void main(String[] args) {

        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int[][] arr = new int[n][n];

        // // Taking Input for array
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // arr[i][j] = scn.nextInt();
        // }
        // }

        // Taking automated hardcoded Input
        int m = 4;
        int n = 4;
        var str = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16";
        String[] elementsInArrayFormat = str.split(" ");
        int[][] arr = new int[m][n];
        int conter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(elementsInArrayFormat[conter]);
                conter++;
            }
        }

        // display the matrix first for reference
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        // Taking input for number to be searched
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        // Searcing logic
        int i = 0;
        int j = arr.length - 1;
        while (i < arr.length && j >= 0) { // both should be true hence '&&'
        
            if (arr[i][j] == num) {
                System.out.println("i: " + i + ", j: " + j);
                return;

            }
            if (arr[i][j] < num) {
                i++; // moving down
            } else {
                j--; // moving left
            }
        }
        System.out.println("Number not found!!");

    }
}
