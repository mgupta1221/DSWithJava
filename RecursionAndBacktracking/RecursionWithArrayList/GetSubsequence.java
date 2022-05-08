package RecursionAndBacktracking.RecursionWithArrayList;

import java.util.ArrayList;
// https://www.youtube.com/watch?v=Sa5PmCFF_zI

public class GetSubsequence {
    public static void main(String[] args) {
        String str = "abc"; // Output should be ["", "a", "b", "c", "ab", "bc", "ac", "abc"]

        ArrayList<String> arrList = new ArrayList<>();
        arrList = getSS(str);
        System.out.println(arrList);

    }

    public static ArrayList<String> getSS(String str) {
        // say string is "abc"
        if (str.length() == 0) {
            ArrayList<String> tempArraylist = new ArrayList<>();
            tempArraylist.add(""); // Blank string ki ek subString hogi, blank itself (2^0 =1)... this will return
                                   // [" "] , not []
            return tempArraylist;

        }
        // Getting first Character "a"
        String firstChar = str.substring(0, 1);
        // Getting rest of Characters "bc"
        String restOfString = str.substring(1);

        ArrayList<String> subArraylist = new ArrayList<>();
        // making recursive call on "bc" and getting the result back
        subArraylist = getSS(restOfString);

        // creating result array
        ArrayList<String> concatArrayList = new ArrayList<>();

        // looping through ["","b","c","bc"]
        for (int i = 0; i < subArraylist.size(); i++) {

            // adding "a" and " " to each item of array
            concatArrayList.add(firstChar + subArraylist.get(i));
            concatArrayList.add("" + subArraylist.get(i));
        }

        // returning final result
        return concatArrayList;
    }

}
