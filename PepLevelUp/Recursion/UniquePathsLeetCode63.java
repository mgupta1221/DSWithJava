
package PepLevelUp.Recursion;

public class UniquePathsLeetCode63 {

    public static int floodFill(int sr, int sc, int dr, int dc, int[][] dir, String[] dirNames,
            int[][] obstacles, String path, boolean[][] vis) {

        if (sr == dr && sc == dc) {
            return 1;
        }
        int count = 0;

        for (int i = 0; i < dir.length; i++) {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if (r >= 0 && c >= 0 && r <= dr && c <= dc && obstacles[r][c] == 0) {
                count += floodFill(r, c, dr, dc, dir, dirNames, obstacles, path + dirNames[i], vis);
            }
        }

        return count;

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dir = { { 0, 1 }, { 1, 0 } };
        String[] dirS = { "r", "d" };
        boolean[][] vis = new boolean[3][3];
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                vis[i][j] = false;
            }
        }
        // Notice we decide the array from Obstacle grid itself as per Leetcode ask for
        // this question.
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) return 0;
        return floodFill(0, 0, m - 1, n - 1, dir, dirS, obstacleGrid, "", vis);
    }

    public static void main(String[] args) {
        // System.out.println(mazePath(0, 0, 2, 2, ""));

        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        // generic and scalable solution(scalable for any direction movement)

    }

}