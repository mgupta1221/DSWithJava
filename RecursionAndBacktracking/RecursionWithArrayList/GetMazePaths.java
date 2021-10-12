package RecursionAndBacktracking.RecursionWithArrayList;

import java.util.ArrayList;

//Quesiton: https://www.youtube.com/watch?v=ox3TswFFKDI
//Solution: https://www.youtube.com/watch?v=7i41gZLXe5k

public class GetMazePaths {
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

        ArrayList<String> hpaths = new ArrayList<>(); ///Defined then separately becuase we have to apply condition unline other examples
        ArrayList<String> cPaths = new ArrayList<>();


        if (sc < dc) {// We apply this condition here so that we do not have to manage bounce beyond max rows or max Columns in the BASE CONDITION
            hpaths = getMazePaths(sr, sc + 1, dr, dc); // Conditionally calling
        }
        if (sr < dr) {
            cPaths = getMazePaths(sr + 1, sc, dr, dc);
        }

        ArrayList<String> finalResult = new ArrayList<>();
        for (int i = 0; i < hpaths.size(); i++) {
            finalResult.add("h" + hpaths.get(i)); //adding "h" when moving hosrintally
        }

        for (int i = 0; i < cPaths.size(); i++) {
            finalResult.add("v" + cPaths.get(i));
        }

        return finalResult;

    }

}
