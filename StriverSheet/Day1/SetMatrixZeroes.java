package StriverSheet.Day1;

public class SetMatrixZeroes {

    // https://leetcode.com/problems/set-matrix-zeroes/

    // Bruteforce and Better Approach: https://www.youtube.com/watch?v=M65xBewcqcI&t=309s
    // Best Approach with least Time and Space Complexity: https://www.youtube.com/watch?v=zgaOU5aInOc&t=507s

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] col = new int[m];
        int[] row = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = 1;
                    row[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (col[i] == 1 || row[j] == 1) {
                    matrix[i][j] = 0;
                }
            }

        }

    }

    public static void main(String[] args) {
        int[][] inputMatrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        printMatrix(inputMatrix);
        setZeroes(inputMatrix);
        printMatrix(inputMatrix);
    }

    public static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] col = new int[m];
        int[] row = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

    }

}
