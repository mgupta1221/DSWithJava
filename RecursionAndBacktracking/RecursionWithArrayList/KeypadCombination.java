package RecursionAndBacktracking.RecursionWithArrayList;

import java.util.*;

// Question: https://www.youtube.com/watch?v=97mF4juql6g
//Solution : https://www.youtube.com/watch?v=3fjt19bjs3A

public class KeypadCombination {
    static String[] keys = { "abc", "def", "ghi", "jkl", "mnopq", "rs", "tuvw", "xyz" };

    public static void main(String[] args) {
        // Part 1: This is to "Print" key combinations
         printKeyPad("23", "");

        // Part 2: This is to "GET" key combinations
        // ArrayList<String> combinations = getKPC(alphaValues);
        // System.out.println(combinations);

        // ArrayList<String> combinations = getKPC2("234");
        // System.out.println(combinations);

    }

    // THis is to "GET" combinations say the input is ["375"]
    public static ArrayList<String> getKPC2(String keysPressed) {

        // Base condition
        if (keysPressed.length() == 0) {
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        //
        char firstWord = keysPressed.charAt(0); // Getting the first word - "3"

        // Getting the rest of strings in a new Arraylist i.e. ["4" ]

        // here we use Sublist() function of ArrayList which returns List<String> so we
        // converted it into ArrayList
        String restOfAlphaValues = keysPressed.substring(1); // "4"

        // Making reursive call now, assuming the code will work for 2 set of
        // values(Faith part ) ["xyz", "rs" ]
        ArrayList<String> rres = getKPC2(restOfAlphaValues); // assuming we will get result for["75"] i.e.
                                                             // ["xr","xs","yr","ys","zr","zs"]

        ArrayList<String> result = new ArrayList<>();
        String key1Keys = keys[Integer.parseInt(firstWord + "")];

        // Now take each charcter of "jkl" (firstWord below) and concatenate with each
        // value of ["xr","xs","yr","ys","zr","zs"] i.e. "rres" variable
        for (int i = 0; i < key1Keys.length(); i++) {

            for (int j = 0; j < rres.size(); j++) {
                result.add(key1Keys.charAt(i) + rres.get(j));
            }
        }
        return result;

    }

    // If you want to Print and not 'get' than use
    public static void printKeyPad(String str, String ros) {

        if (str.length() == 0) {
            System.out.print(ros + " ");
            return;
        }

        String ch1 = str.substring(0, 1);
        String remStr = str.substring(1);

        String chars = keys[Integer.parseInt(ch1)];

        for (int i = 0; i < chars.length(); i++) {
            printKeyPad(remStr, chars.charAt(i) + ros);
        }

    }

}
