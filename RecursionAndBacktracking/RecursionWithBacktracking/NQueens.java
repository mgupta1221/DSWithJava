
public class NQueens {

    // Question :
    // https://www.youtube.com/watch?v=prZJ0hA43NU&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=50

    // Solution:
    // https://www.youtube.com/watch?v=05y82cP3bJo&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=51

    // Approach:
    // We take advnatge of the fact that one row cannot have 2 queens, so "1 queen
    // per row" should be there.
    // Way to solution this- First simply try to fill queens in the matrix such that
    // one queen is only there per row (without considering if queen can kill other
    // queen for now) - recursive call
    // Next, improvise the code with a condition to fill queens conditionally such
    // that they cannot kill each other
    public static void main(String[] args) {

        int arraySize = 4;
        int[][] chess = new int[arraySize][arraySize];
        String queensSofar = "";
        printNQueens(chess, queensSofar, 0);

    }

    public static void printNQueens(int[][] chess, String queensSofar, int row) {

        if (row == chess.length) {
            System.out.println(queensSofar);
            return;
        }

        // iterating columns for each row
        for (int col = 0; col < chess[0].length; col++) {

            // putting that extra condition to fill queens conditionally with 'if' clause
            if (IsItSafeToPlaceQueen(chess, row, col) == true) {
                chess[row][col] = 1;
                printNQueens(chess, queensSofar + "[row:" + row + ",col:" + col + "], ", row + 1); // Notice row+1, we
                                                                                                   // are moving rows
                                                                                                   // too
                chess[row][col] = 0;
            }

        }

    }

    // We have to check in top, dialognally-left and diagonally-right. No need to
    // check for the row below becuase no queen has not been placed there yet(below
    // the current row) as are moving from top row to the the last row serially
    public static boolean IsItSafeToPlaceQueen(int[][] chess, int row, int col) {

        // checking top cells
        for (int r = row - 1; r >= 0; r--) {
            if (chess[r][col] == 1) {
                return false;
            }

        }
        // checking left diagnal
        for (int r = row - 1, j = col - 1; r >= 0 && j >= 0; r--, j--) {
            if (chess[r][j] == 1) {
                return false;
            }

        }

        // checking right diagnal
        for (int r = row - 1, j = col + 1; r >= 0 && j < chess[0].length; r--, j++) {
            if (chess[r][j] == 1) {
                return false;
            }

        }

        return true;

    }

}
