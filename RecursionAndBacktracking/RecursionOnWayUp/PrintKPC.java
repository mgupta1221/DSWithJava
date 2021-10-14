package RecursionAndBacktracking.RecursionOnWayUp;

import java.util.ArrayList;

// Solution  : https://www.youtube.com/watch?v=Ke8TPhHdHMw
public class PrintKPC {
    public static void main(String[] args) {
        String str = "678";

        String[] possibleKeys = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

        printKPC(str, "");

    }

    public static void printKPC(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0); // first character
        String ros = str.substring(1); // rest of the string

        // recursive calls
        printKPC(ros, ans + "");
        printKPC(ros, ans + ch);

    }

}
