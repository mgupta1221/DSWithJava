
package PepLevelUp.Recursion;

public class UniquePathsLeetCode62 {

    // driver function
    public static int uniquePaths(int m, int n) {
        int[][] directions = { { 0, 1 }, { 1, 0 } };
        String[] dirNames = { "r", "d" };
        return getUniquePaths(0, 0, m - 1, n - 1, directions, dirNames, "");

    }

    // recursive function
    public static int getUniquePaths(int sr, int sc, int er, int ec, int[][] directions, String[] dirNames,
            String psf) {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < dirNames.length; i++) {

            int r = sr + directions[i][0];
            int c = sc + directions[i][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += getUniquePaths(r, c, er, ec, directions, dirNames, psf + dirNames[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = uniquePaths(3, 7);
        System.out.println(count);

    }

}