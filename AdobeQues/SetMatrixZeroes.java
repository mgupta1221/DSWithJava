package AdobeQues;

public class SetMatrixZeroes {

    // https://leetcode.com/problems/set-matrix-zeroes/

    // Bruteforce and Better Approach:
    // https://www.youtube.com/watch?v=M65xBewcqcI&t=309s
    // Best Approach with least Time and Space Complexity:
    // https://www.youtube.com/watch?v=zgaOU5aInOc&t=507s

    // Better Approach

    // Step 1: Create 2 linear arrays- One for Row , One for Column
    // Step 2: set their values as 1 if Matrix cell is 0
    // Step 3: Now iterate through the matrix and check if both new arrays has value
    // as 1 than set that cell as 0
    // Space Complexity: (N + M)
    // Time Complexity: 2*(N*M) ~ N*M
    public static void setZeroes_Better(int[][] matrix) {
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

    // Best Approach
    public static void setZeroes_Best(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean isRow = false;
        boolean isCol = false;

        // To find if first row has any 0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isRow = true;
            }
        }
        // To find if first column has any 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
        }

        // Now traverse the full array (leaving first Col and first Row) and if the
        // current cell comes 0 than set the corresponding first row cell to 0 and first
        // col to 0
        // Notice below loop runs from (1,1) and not (0,0)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Now traverse first row and if element is 0 and than convert all cells of
        // that row to 0
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Now traverse first column and if element is 0 and than convert all cells of
        // that column to 0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (isRow == true) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;

            }
        }
        if (isCol == true) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] inputMatrix = { { 1 }, { 0 } };
        // int[][] inputMatrix = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 1 } };
        printMatrix(inputMatrix);
        // setZeroes_Better(inputMatrix);

        setZeroes_Best(inputMatrix);
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
