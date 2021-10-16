package RecursionAndBacktracking.RecursionOnWayUp;

// This question is similar to GetKeyPressCombination in "Recursion WithArraysLists" section
// there we were returning the values using ArrayList but here we have to print them

// Key is that we have taken an extra parameter in the function called 'ans' to calculate the KeyCombination
// in each iteration and printing it at Base Condition 

// Question : https://www.youtube.com/watch?v=HVCajDe2Uus
// Solution : https://www.youtube.com/watch?v=4yMtvToiJE0

public class PrintKPC {
    // Global variable
    static String[] codes = { ".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void main(String[] args) {
        String str = "678";
        printKPC(str, "");

    }

    // solving for str="678"
    public static void printKPC(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        int firstChar = str.charAt(0) - '0'; // 6 , "- '0'"i used to convert char to int
        String restOfString = str.substring(1); // 78

        String codeForCh = codes[firstChar]; // "pqrs"

        for (int i = 0; i < codeForCh.length(); i++) { // Loop for 'p', 'q', 'r','s'

            char charOption = codeForCh.charAt(i);
            printKPC(restOfString, ans + charOption);
        }

    }

}
