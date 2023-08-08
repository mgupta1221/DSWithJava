package AdobeQues;

import java.util.ArrayList;

public class SpiralTraversalMatrix {

    // Problem:
    // https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
    // New

    // Approach : Take 4 variables for: Left, Right, Top, Bottom

    public static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        // Primary condition
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Notice we have to put below condition additonally, else it prints few values again
            // which were already printed in first 2 loops
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Notice this below condition similar to above
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        // int matrix[][] = { { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 } };

        int matrix[][] = { { 6, 6, 2, 28, 2 },
                { 12, 26, 3, 28, 7 },
                { 22, 25, 3, 4, 23 } };

        ArrayList<Integer> result = spirallyTraverse(matrix, matrix.length, matrix[0].length);
        for (Integer n : result) {
            System.out.print(n + " ");
        }
    }
}
