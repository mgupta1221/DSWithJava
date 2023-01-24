package StriverSheet.Day3;

public class test1 {

    public static int uniquePaths(int m, int n) {
        // int[] result = new int[1];
        int result = 0;
        int[][] dp = new int[m + 1][n + 1];

        String[] dirNames = { "R", "L" };
        int[][] dr = { { 0, 1 }, { 1, 0 } };
        result = uniquePaths_helper(0, 0, m, n, dr, dirNames, dp);
        return result;

    }

    public static int uniquePaths_helper(int startx, int starty, int endx, int endy, int[][] dr, String[] dirNames,
            int[][] dp) {
        if (startx >= endx || starty >= endy) {
            return 0;
        }
        if (startx == endx - 1 && starty == endy - 1) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < dirNames.length; i++) {
            int row = dr[i][0];
            int column = dr[i][1];
            result += uniquePaths_helper(startx + row, starty + column, endx, endy, dr, dirNames, dp);

        }
        return result;

    }

    public static void main(String[] args) {

        int totalPaths = uniquePaths(3, 7);

        System.out.println("result:" + totalPaths);

    }

}
