package PepLevelUp.Recursion;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

public class Rat_In_A_Maze {
    public static ArrayList<String> findPath(int[][] obstacles, int n) {

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        String[] dirNames = { "R", "D", "L", "U" };
        Boolean[][] visited = new Boolean[n][n];
        ArrayList<String> resultPaths = new ArrayList<String>();
        if (obstacles[0][0] == 0)
            return resultPaths;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }

        ArrayList<String> paths = getAllPaths(0, 0, n - 1, n - 1, obstacles, directions, dirNames, visited,
                "", resultPaths);
        return paths;
    }

    public static ArrayList<String> getAllPaths(int sr, int sc, int dr, int dc, int[][] obstacles,
            int[][] directions, String[] dirNames, Boolean[][] visited, String path,
            ArrayList<String> resultPaths) {

        if (sr == dr && sc == dc) {
            resultPaths.add(path);
        }
        visited[sr][sc] = true;
        for (int i = 0; i < dirNames.length; i++) {
            int r = sr + directions[i][0];
            int c = sc + directions[i][1];
            if (r >= 0 && c >= 0 && r <= dr && c <= dc && visited[r][c] == false && obstacles[r][c] == 1) {
                getAllPaths(r, c, dr, dc, obstacles, directions, dirNames, visited, path + dirNames[i], resultPaths);
            }
        }
        visited[sr][sc] = false;
        return resultPaths;
    }

    public static void main(String[] args) {
        int[][] obstacles = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        int n = 4;

        ArrayList<String> paths = findPath(obstacles, n);

        for (String path : paths) {
            System.out.println(path);
        }

    }

}
