package RecursionAndBacktracking.RecursionWithArrayList;

import java.util.*;

// Question: https://www.youtube.com/watch?v=97mF4juql6g
//Solution : https://www.youtube.com/watch?v=3fjt19bjs3A

public class KeypadCombination {
    public static void main(String[] args) {
        String[] keys = { "abc", "def", "ghi", "jkl", "mnopq", "rs", "tuvw", "xyz" };

        int keyPressed = 573;

        char c = '6' - 48;

        System.out.println(c);

        ArrayList<Integer> keyValues = new ArrayList<>(); // [5,7,3]
        while (keyPressed != 0) {
            keyValues.add(keyPressed % 10);
            keyPressed = keyPressed / 10;
        }
        System.out.println(keyValues);
        ArrayList<String> alphaValues = new ArrayList<>(); // ["rs","xyz", "jkl"]
        for (int val : keyValues) {
            alphaValues.add(keys[val]);
        }
        System.out.println(alphaValues);

        ArrayList<String> combinations = getKPC(alphaValues);
        System.out.println(combinations);

    }

    // say the input is ["jkl","xyz", "rs"]
    public static ArrayList<String> getKPC(ArrayList<String> alphaValues) {

        // Base condition
        if (alphaValues.size() == 0) {
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        //
        String firstWord = alphaValues.get(0); // Getting the first word - "jkl"

        // Getting the rest of strings in a new Arraylist i.e. ["xyz", "rs" ]

        // here we use Sublist() function of ArrayList which returns List<String> so we
        // converted it into ArrayList
        ArrayList<String> restOfAlphaValues = new ArrayList<String>(alphaValues.subList(1, alphaValues.size()));

        // Making reursive call now, assuming the code will work for 2 set of
        // values(Faith part ) ["xyz", "rs" ]
        ArrayList<String> rres = getKPC(restOfAlphaValues); // assuming we will get result for["xyz", "rs"] i.e.
                                                            // ["xr","xs","yr","ys","zr","zs"]

        ArrayList<String> result = new ArrayList<>();
        // Now take each charcter of "jkl" (firstWord below) and concatenate with each
        // value of ["xr","xs","yr","ys","zr","zs"] i.e. "rres" variable
        for (int i = 0; i < firstWord.length(); i++) {
            char character = firstWord.charAt(i);
            for (int j = 0; j < rres.size(); j++) {
                result.add(character + rres.get(j));
            }
        }
        return result;

    }
}
