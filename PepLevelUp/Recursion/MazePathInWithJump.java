
package PepLevelUp.Recursion;

public class MazePathInWithJump {

    public static int mazePathWithJump(int sr, int sc, int er, int ec, int[][] dir, String[] dirS, String psf) {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dirS.length; d++) {
            // inner loop for jump logic..using radius approach
            // column side mai kitna move kar sakta hu, row side mai kitna move kar sakta
            // hu..
            // utna hi radius badh sakta hai
            for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];
                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    count += mazePathWithJump(r, c, er, ec, dir, dirS, psf + dirS[d] + rad);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 }};
        String[] dirS = { "right", "down", "diagnoal" };
        boolean[][] vis = new boolean[3][3];
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                vis[i][j] = false;
            }
        }
        System.out.println(mazePathWithJump(0, 0, 2, 2, dir, dirS, ""));
    }

}