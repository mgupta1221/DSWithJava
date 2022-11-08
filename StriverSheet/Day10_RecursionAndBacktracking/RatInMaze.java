package StriverSheet.Day10_RecursionAndBacktracking;

import java.util.ArrayList;

public class RatInMaze {

    // Geeks For geeks : Rat in a maze
    // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

    public static ArrayList<String> findPath(int[][] m, int n) {

        // creating a visited array
        boolean[][] visited = new boolean[4][4];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }

        // creating directions
        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        String[] dirNames = { "R", "D", "U", "L" };

        ArrayList<String> result = new ArrayList<>();

        getAllPathsHelper(0, 0, n - 1, n - 1, m, visited, directions, dirNames, "", result);
        return result;

    }

    public static void getAllPathsHelper(int sr, int sc, int dr, int dc,
            int[][] m, boolean[][] visited, int[][] directions, String[] dirNames,
            String answerSofar, ArrayList<String> result) {
        // Base condition
        if (sr == dr && sc == dc) {
            result.add(answerSofar);
        }

        visited[sr][sc] = true;
        for (int i = 0; i < dirNames.length; i++) {
            int r = sr + directions[i][0];
            int c = sc + directions[i][1];
            if (r >= 0 && c >= 0 && r <= dr && c <= dc && visited[r][c] == false && m[r][c] == 1)
                getAllPathsHelper(r, c, dr, dc, m, visited, directions, dirNames, answerSofar + dirNames[i], result);

        }
        visited[sr][sc] = false;

    }

    public static void main(String[] args) {

        int[][] m = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        int N = 4;
        ArrayList<String> resultPaths = findPath(m, N);
        for (String str : resultPaths) {
            System.out.println(str);
        }
    }
}
