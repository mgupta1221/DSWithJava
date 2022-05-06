
package PepLevelUp.Recursion;

import java.util.ArrayList;

public class MazePathInWithJump {

    // Quesiton: https://www.youtube.com/watch?v=F6T3tD8Pw20
    // Solution: https://www.youtube.com/watch?v=VaGBRiSdtFI

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> emptyArrList = new ArrayList<>();
            // 3,3 se 3,3 par jane ka ek rasta hai...hilo hi mat khade raho
            emptyArrList.add("");
            return emptyArrList;
        }

        ArrayList<String> hpaths = new ArrayList<>();

        ArrayList<String> cPaths = new ArrayList<>();
        ArrayList<String> dPaths = new ArrayList<>();

        ArrayList<String> finalResult = new ArrayList<>();
        for (int i = 1; i <= dc - sc; i++) { // important thing is this loop runnign from 0 to number
                                             // of possible jumps
                                             // i.e. dc-sc
            // and it is important to note that loop has to start from 1 else it will go
            // infinite.
            hpaths = getMazePaths(sr, sc + i, dr, dc);
            for (int k = 0; k < hpaths.size(); k++) {
                finalResult.add("h" + i + hpaths.get(k)); // adding "h" with index value when moving horizntally
            }
        }

        for (int i = 1; i <= dr - sr; i++) {
            cPaths = getMazePaths(sr + i, sc, dr, dc);
            for (int k = 0; k < cPaths.size(); k++) {
                finalResult.add("v" + i + cPaths.get(k));
            }
        }

        for (int i = 1; i <= dr - sr && i < dc - sc; i++) {
            dPaths = getMazePaths(sr + i, sc + i, dr, dc);
            for (int k = 0; k < dPaths.size(); k++) {
                finalResult.add("d" + i + dPaths.get(k));
            }
        }

        return finalResult;

    }

    // Taught by Rajneesh
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
        // Taught by Rajneesh

        // int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
        // String[] dirS = { "h", "v", "d" };
        // boolean[][] vis = new boolean[3][3];
        // for (int i = 0; i < vis.length; i++) {
        // for (int j = 0; j < vis[0].length; j++) {
        // vis[i][j] = false;
        // }
        // }
        // System.out.println(mazePathWithJump(0, 0, 2, 2, dir, dirS, ""));

        System.out.println("-------------------");
        ArrayList<String> arrList = new ArrayList<>();
        int m = 3, n = 2;
        arrList = getMazePaths(0, 0, m, n);
        System.out.println(arrList);

    }

}
