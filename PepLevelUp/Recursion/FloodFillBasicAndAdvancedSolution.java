
package PepLevelUp.Recursion;

public class FloodFillBasicAndAdvancedSolution {

    public static void floodFillSimpleSolution(int sr, int sc, int dr, int dc, Boolean[][] vis, int[][] obstacleGrid,
            String path) {

        if (sr < 0 || sc < 0 || sr > dr || sc > dc ||
                obstacleGrid[sr][sc] == 0 || vis[sr][sc]) {
            return;
        }

        if (sr == dr && sc == dc) {
            System.out.println(path);
            return;
        }

        vis[sr][sc] = true;

        floodFillSimpleSolution(sr + 1, sc, dr, dc, vis, obstacleGrid, "D" + path);
        floodFillSimpleSolution(sr, sc + 1, dr, dc, vis, obstacleGrid, "R" + path);
        floodFillSimpleSolution(sr - 1, sc, dr, dc, vis, obstacleGrid, "U" + path);
        floodFillSimpleSolution(sr, sc - 1, dr, dc, vis, obstacleGrid, "L" + path);

        vis[sr][sc] = false;
        return;

    }

    // Driver function for above function- this is called from main()
    public static void floodFillSimpleSolution(int[][] obstacles, int n) {

        Boolean[][] visited = new Boolean[n - 1][n - 1];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                visited[i][j] = false;
            }
        }
        floodFillSimpleSolution(0, 0, n - 1, n - 1, visited, obstacles, "");

    }

    // Generic and Advanced implementation
    public static int floodFill(int sr, int sc, int dr, int dc, int[][] dir, String[] dirS, String path,
            boolean[][] vis) {

        if (sr == dr && sc == dc) {
            System.out.println(path);
            return 1;
        }
        int count = 0;
        vis[sr][sc] = true;
        for (int i = 0; i < dir.length; i++) {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if (r >= 0 && c >= 0 && r <= dr && c <= dc && !vis[r][c]) {
                count += floodFill(r, c, dr, dc, dir, dirS, path + dirS[i], vis);
            }
        }
        vis[sr][sc] = false;
        return count;
    }

    public static void main(String[] args) {
        // System.out.println(mazePath(0, 0, 2, 2, ""));

        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };
        String[] dirS = { "r", "d", "w", "e", "u", "s", "l", "n" };
        Boolean[][] vis = new Boolean[4][4];
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                vis[i][j] = false;
            }
        }

        int[][] obstacles = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        // simple solution for vertical, horizontla and diagonal movement
        floodFillSimpleSolution(0, 0, 3, 3, vis, obstacles, "");

        // generic and scalable solution(scalable for any direction movement)
        // This does not have obstacles, which can be added same as in above Simple Solution
        // System.out.println(floodFill(0, 0, 2, 2, dir, dirS, "", vis));
    }

}