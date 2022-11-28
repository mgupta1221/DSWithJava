package StriverSheet.Day9_Recursion;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                chess[i][j] = '.';
        solveNQueensHelper(chess, 0, result);
        return result;
    }

    public static void solveNQueensHelper(char[][] chess, int row, List<List<String>> result) {

        if (row == chess.length) {
            List<String> subResult = new ArrayList<>();
            for (int i = 0; i < chess.length; i++) {
                //System.out.println(String.valueOf(chess[i]));
                subResult.add(String.valueOf(chess[i]));
            }
            result.add(new ArrayList<>(subResult));
            return;
        }

        for (

                int col = 0; col < chess[0].length; col++) {
            if (isSafeToPlace(chess, row, col)) {
                chess[row][col] = 'Q';
                solveNQueensHelper(chess, row + 1, result);
                chess[row][col] = '.';
            }
        }

    }

    public static boolean isSafeToPlace(char[][] chess, int row, int col) {

        for (int r = row - 1; r >= 0; r--) {
            if (chess[r][col] == 'Q') {
                return false;
            }
        }

        for (int r = row - 1, c = col + 1; c < chess[0].length && r >= 0; r--, c++) {
            if (chess[r][c] == 'Q') {
                return false;
            }
        }

        for (int r = row - 1, c = col - 1; c >= 0 && r >= 0; r--, c--) {
            if (chess[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<List<String>> result = solveNQueens(4);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
