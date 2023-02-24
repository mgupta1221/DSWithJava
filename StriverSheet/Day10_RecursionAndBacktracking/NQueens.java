package StriverSheet.Day10_RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

// Problem:  https://leetcode.com/problems/n-queens/

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                chess[i][j] = '.';
        solveNQueensHelper(chess, 0, result);
        return result;

    }

    public static void solveNQueensHelper(char[][] chess, int row,
            List<List<String>> result) {

        if (row == chess.length) {
            result.add(constructBoard(chess)); // notice how we are adding chess board
            return;
        }
        for (int col = 0; col < chess[0].length; col++) {
            if (isItSafetoPlaceQueen(chess, row, col)) {
                chess[row][col] = 'Q';
                solveNQueensHelper(chess, row + 1, result);
                chess[row][col] = '.';
            }
        }
    }

    public static boolean isItSafetoPlaceQueen(char[][] chess, int r, int c) {

        // upper rows
        for (int i = r - 1; i >= 0; i--) {
            if (chess[i][c] == 'Q') {
                return false;
            }
        }

        // left diaognal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // right diaognal
        for (int i = r - 1, j = c + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // left columns
        for (int j = c - 1; j >= 0; j--) {
            if (chess[r][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

    public static List<String> constructBoard(char[][] chess) {
        List<String> resultBoard = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            String s = new String(chess[i]); // converting char[] array to String
            resultBoard.add(s);
        }
        return resultBoard;

    }

    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        for (List<String> strList : result) {
            for (String str : strList) {
                System.out.println(str);
            }
            System.out.println("===========");
        }
    }

}
