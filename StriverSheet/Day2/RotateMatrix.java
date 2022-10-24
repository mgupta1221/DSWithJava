package StriverSheet.Day2;

// LC 48: https://leetcode.com/problems/rotate-image/
// Rotate matrix by 90 degree in-place

public class RotateMatrix {

    // Bruteforce approach (Not in-place):
    // Create another matrix and place first row into last column , second row and
    // second last column..etc..
    public static int[][] RotateMatrix_Bruteforce(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[0].length; j++) {
                rotatedMatrix[j][rotatedMatrix.length - i - 1] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    // Optimised approach:

    // Rotating a matrix is equivalent to :
    // Step 1: Transpose the matrix
    // Step 2: Reverse each row

    public static int[][] RotateMatrix_Optimised(int[][] matrix) {

        // Transposing a matrix
        // Notice to transpose: 'j' has to start from i and not 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j, i, j);
            }
        }

        // Reversing each row
        // Notice to rotate: we are moving 'j' only till half
        int cols = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j];
                matrix[i][cols - j] = temp;
            }

        }

        return matrix;
    }

    public static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[j2][i2];
        matrix[j2][i2] = temp;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        printMatrix(arr);
        int rotated[][] = RotateMatrix_Optimised(arr);
        System.out.println("Rotated Image");
        printMatrix(rotated);

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
