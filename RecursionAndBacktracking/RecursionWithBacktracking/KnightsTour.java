public class KnightsTour {

    // Quesiton:
    // https://www.youtube.com/watch?v=EgoKDqfpbMg&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=52

    // Answer:
    // https://www.youtube.com/watch?v=SP880DBRJ_8&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=53
    public static void main(String[] args) {
        int[][] chess = new int[5][5];

        int startingRowNumber = 2;
        int startingColNumber = 3;

        printKnightsTour(chess, startingRowNumber, startingColNumber, 1);

    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {

        // Notice the condition "chess[r][c] > 0" which means the cell is already
        // filled, so return
        if (r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] > 0) {
            return;
        }

        if (upcomingMove == 25) {

            // Notice if we reached the last cell we still have to fill it hence we are
            // filling and removing value from chess's cell

            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = upcomingMove;
        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);
        chess[r][c] = 0;

    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
