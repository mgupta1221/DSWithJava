package AdobeQues;

public class FindIfPathExists {
    public static boolean is_Possible(int[][] grid) {

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        Boolean[] result = { false };
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int row = 0;
        int col = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        is_Possible_helper(grid, row, col, directions, visited, result);
        return result[0];

    }

    public static void is_Possible_helper(int[][] grid, int row, int col,
            int[][] directions, boolean visited[][], Boolean[] result) {
        if (row == grid.length || col == grid[0].length) {
            result[0] = false;
            return;
        }
        if (grid[row][col] == 2) {
            result[0] = true;
            return;
        }

        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if ((newRow < 0 || newCol < 0) ||
                    (newRow == grid.length || newCol == grid[0].length) ||
                    grid[newRow][newCol] == 0 ||
                    visited[newRow][newCol]) {
                continue;
            }
            visited[newRow][newCol] = true;

            is_Possible_helper(grid, newRow, newCol,
                    directions, visited, result);

        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 0, 3, 0, 0 }, { 3, 0, 0, 0, 3 }, { 3, 3, 3, 3, 3 }, { 0, 2, 3, 0, 0 },
                { 3, 0, 0, 1, 3 } };

        Boolean result = is_Possible(grid);
        System.out.println(result);
    }
}
