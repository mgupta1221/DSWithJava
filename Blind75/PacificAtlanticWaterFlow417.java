package Blind75;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Arrays;;

// Solve using BFS, the leftmost column, rightmost column, top row and last row...these 4
// can always flow through oceans, so they are added to queue by default.

// // In helper code, we only add the new co-ordinates to Queue only if:
// 1) They have not been reached before
// 2) heights[newX][newY] >= heights[x][y], this means the new coordicates are at higher level
// than the borders so they will allow water to flow.
// Note that we are moving from borders to inside, so borders(previous X,Y) 
// should be at less depth to allow water to flow

// At the end, we match the reachable coordinates of both oceans, if they are part 
// of both Pacific and Atlantic reachable list returnd from bfs helpers,  they are 
// added to the result.
public class PacificAtlanticWaterFlow417 {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }

        int rows = heights.length;
        int cols = heights[0].length;

        // Initialize the Pacific and Atlantic queues with border points
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            pacificQueue.offer(new int[] { i, 0 }); // Left border (Pacific)
            atlanticQueue.offer(new int[] { i, cols - 1 }); // Right border (Atlantic)
        }

        for (int j = 0; j < cols; j++) {
            pacificQueue.offer(new int[] { 0, j }); // Top border (Pacific)
            atlanticQueue.offer(new int[] { rows - 1, j }); // Bottom border (Atlantic)
        }

        // Mark cells reachable by Pacific and Atlantic
        boolean[][] pacificReachable = bfs(heights, pacificQueue, rows, cols);
        boolean[][] atlanticReachable = bfs(heights, atlanticQueue, rows, cols);

        // Find the intersection of both reachable cells
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    // BFS helper method
    private static boolean[][] bfs(int[][] heights, Queue<int[]> queue, int rows, int cols) {
        boolean[][] reachable = new boolean[rows][cols];
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            // Mark cell as reachable
            reachable[x][y] = true;

            // Explore neighbors
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and height condition
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                        !reachable[newX][newY] && heights[newX][newY] >= heights[x][y]) {
                    queue.offer(new int[] { newX, newY });
                }
            }
        }

        return reachable;
    }

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };

        List<List<Integer>> result = pacificAtlantic(heights);

        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }
}
