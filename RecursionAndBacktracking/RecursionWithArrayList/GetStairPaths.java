package RecursionAndBacktracking.RecursionWithArrayList;

import java.util.ArrayList;

//Quesiton: https://www.youtube.com/watch?v=W6cT68K7Hls
//Solution: https://www.youtube.com/watch?v=hMJAlbJIS7E

public class GetStairPaths {
    public static void main(String[] args) {

        ArrayList<String> arrList = new ArrayList<>();
        arrList = getSP(3);
        System.out.println(arrList);

    }

    public static ArrayList<String> getSP(int n) {
        // Notice the difference in Base case from GetSubSequence example
        if (n == 0) {
            ArrayList<String> emptyArrList = new ArrayList<>();
            emptyArrList.add("");
            return emptyArrList;

        } else if (n < 0) {
            ArrayList<String> emptyArrList = new ArrayList<>();
            return emptyArrList;
        }
        // Recursive calls
        ArrayList<String> rres1 = getSP(n - 1);
        ArrayList<String> rres2 = getSP(n - 2);
        ArrayList<String> rres3 = getSP(n - 3);

        ArrayList<String> finalResult = new ArrayList<>();

        // Append 1 to all results that come from (n-1) recursive call above, Similarly for 2 and 3 below
        for (int i = 0; i < rres1.size(); i++) {
            finalResult.add("1" + rres1.get(i));
        }
        for (int i = 0; i < rres2.size(); i++) {
            finalResult.add("2" + rres2.get(i));
        }
        for (int i = 0; i < rres3.size(); i++) {
            finalResult.add("3" + rres3.get(i));
        }
        return finalResult;

    }

}
