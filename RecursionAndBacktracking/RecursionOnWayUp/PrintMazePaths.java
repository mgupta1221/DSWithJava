package RecursionAndBacktracking.RecursionOnWayUp;

//Question: https://www.youtube.com/watch?v=TcCyI-eJMmY&t=1s
// Solution: https://www.youtube.com/watch?v=MHtAA5UE-6Y

public class PrintMazePaths {
    public static void main(String[] args) {
        int dr = 2;
        int dc = 2;

        printAllMazePath(0, 0, dr, dc, "");

    }

    public static void printAllMazePath(int sr, int sc, int dr, int dc, String psf) {
        if (sr > dr || sc > dc) {
            return;
        }

        if (sr == dr && sc == dc) {
            System.out.print(psf + " ");
        }

        //Moving Horizonatally
        printAllMazePath(sr + 1, sc, dr, dc, psf + "h"); //Call Stupid

        //Moving Vertically
        printAllMazePath(sr, sc + 1, dr, dc, psf + "v");

    }

}
