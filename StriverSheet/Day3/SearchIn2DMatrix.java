package StriverSheet.Day3;

// LC 74  - Search  a 2D Matrix - https://leetcode.com/problems/search-a-2d-matrix/

// Given condition is the 2D Matrix is sorted

// Since matrix is sorted efficient way is to apply Binary Search.

// See how we can locate an element in 2D matrix via mid value
// for ith element (say 5th element in a 2D matrix with total columns C):
// RowIndex  =  5/C
// ColIndex  =  5%C

// Remember: DIVIDE BY COLUMNS (not Rows)
// Also,  / is for Row, % is to get Column

public class SearchIn2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length * matrix[0].length) - 1; // No Of Elemnts in 2D matrix=(rows * cols)-1

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalColsInMatrix = matrix[0].length;
            int RowIndexOfMid = mid / totalColsInMatrix;
            int ColIndexOfMid = mid % totalColsInMatrix;

            if (matrix[RowIndexOfMid][ColIndexOfMid] == target) {
                return true;
            } else {
                if (matrix[RowIndexOfMid][ColIndexOfMid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

        int target = 3;

        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
    }
}
