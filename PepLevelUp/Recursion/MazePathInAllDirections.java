
package PepLevelUp.Recursion;

public class MazePathInAllDirections {

    public static int mazePath2(int sr, int sc, int er, int ec, int[][] dir, String[] dirNames, String psf) {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dirNames.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += mazePath2(r, c, er, ec, dir, dirNames, psf + dirNames[d]);
            }
        }
        return count;
    }

    

    public static void main(String[] args) {

        //see image in the folder to check all drections defined below:

        // with all the paths as below, it will go infinite and will cause Mameory out of bound 
        //so try by reducing the paths like 
        //  String[] dirS = { "r", "d", "w" };
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };
        String[] dirS = { "r", "d", "w", "e", "u", "s", "l", "n" };
       
        System.out.println(mazePath2(0, 0, 2, 2, dir, dirS, ""));

    }

}