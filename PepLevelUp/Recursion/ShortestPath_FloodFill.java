
package PepLevelUp.Recursion;

import javax.print.attribute.IntegerSyntax;

public class ShortestPath_FloodFill {

    // Generic and Advanced implementation
    public static int floodFillShortestPath(int sr, int sc, int dr, int dc, int[][] dir,
            String[] dirS, String path, int[][] obstacles, Boolean[][] vis) {

        if (sr == dr && sc == dc) {
            System.out.println(path);// printing path

            // this below line is also a change - because finally we need to return length of 
            // the shortest path
            return path.length();
        }
        int count = 0;
        int min = Integer.MAX_VALUE;
        vis[sr][sc] = true;
        for (int i = 0; i < dir.length; i++) {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if (r >= 0 && c >= 0 && r <= dr && c <= dc && !vis[r][c] && obstacles[r][c] == 1) {
                count = floodFillShortestPath(r, c, dr, dc, dir, dirS, path + dirS[i], obstacles, vis);
                // this is the main line to keep calculating the minimum
                min = Math.min(count, min);
            }
        }

        vis[sr][sc] = false;
        return min;
    }

    public static void main(String[] args) {
        // System.out.println(mazePath(0, 0, 2, 2, ""));

        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        String[] dirS = { "r", "d", "u", "l" };

        Boolean[][] vis = new Boolean[4][5];
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                vis[i][j] = false;
            }
        }

        int[][] obstacles = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 1 },
        };

        System.out.println(floodFillShortestPath(0, 0, 2, 3, dir, dirS, "", obstacles, vis));
    }

}