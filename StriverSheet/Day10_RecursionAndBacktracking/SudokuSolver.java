package StriverSheet.Day10_RecursionAndBacktracking;

// Problem:  https://leetcode.com/problems/sudoku-solver/

// Solution: Similar to NQueens problem
public class SudokuSolver {

    public static boolean solveSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isPossibleFit(board, i, j, ch)) {
                            board[i][j] = ch;

                            if (solveSudoku(board)) {// after placing the value go again in recursion to solve board
                                                     // further
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false; // this is important else it will go into infinite loop - control will only
                                  // reach here position[i][j] cannot be filled with any number between 1-9
                }
            }
        }

        return true;

    }

    public static boolean isPossibleFit(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board[0].length; i++) {
            // condition 1
            if (board[row][i] == c) {
                return false;
            }

            // condition 2
            if (board[i][col] == c) {
                return false;
            }

            int row1 = 3 * (row / 3) + i / 3; // Note that this expression is not similar to: = row + (i / 3)..it will
                                              // resolve like 3*(1)+0
            int col1 = 3 * (col / 3) + i % 3;
            if (board[row1][col1] == c) {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }

    }

}
