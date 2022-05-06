package RecursionAndBacktracking.RecursionWithArrayList;

import java.util.ArrayList;

//Quesiton: https://www.youtube.com/watch?v=F6T3tD8Pw20
//Solution: https://www.youtube.com/watch?v=VaGBRiSdtFI

public class GetMazePathsWithJump {
    public static void main(String[] args) {

        ArrayList<String> arrList = new ArrayList<>();
        int m = 2, n = 2;
        arrList = getMazePaths(0, 0, m, n);
        System.out.println(arrList);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> emptyArrList = new ArrayList<>();
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
                finalResult.add("h" + i + hpaths.get(k)); // adding "h" with index value when moving hosrintally
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

}
