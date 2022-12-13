package StriverSheet.Day14;
import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOrange {
    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        int totalOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
                if (grid[i][j] != 0) {
                    totalOranges++;
                }
            }
        }
        if (totalOranges == 0)
            return 0;

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int countInMinutes = 0;
        int orangesHandled = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            orangesHandled = orangesHandled + size;// total kitne rotten oranges target kiye har iteration mai
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < directions.length; j++) {
                    int x = point[0] + directions[j][0];
                    int y = point[1] + directions[j][1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[] { x, y });
                    }

                }
            }
            if (queue.size() != 0)
                countInMinutes++;
        }
        int result = totalOranges == orangesHandled ? countInMinutes : -1;
        return result;
    }

    public static void main(String[] args) {
        int[][] grids = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int result = orangesRotting(grids);
        System.out.println(result);
    }
}
